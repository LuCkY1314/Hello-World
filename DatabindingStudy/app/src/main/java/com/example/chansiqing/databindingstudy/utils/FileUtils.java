package com.example.chansiqing.databindingstudy.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Files.FileColumns;
import android.util.Log;

import com.example.chansiqing.databindingstudy.activity.MyApp;
import com.example.chansiqing.databindingstudy.data.Entity;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static final String urlTaobao = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.taobao.taobao/files/AVFSCache/phximgs_top3";
    public static final String urlJD = Environment.getExternalStorageDirectory().getAbsolutePath() + "/image_cache";

    public static List<Entity> getSpecificTypeOfFile(Context context, String[] extension) {
        List<Entity> list = new ArrayList<>();
        //从外存中获取
        Uri fileUri = Files.getContentUri("external");
        //筛选列，这里只筛选了：文件路径和不含后缀的文件名
        String[] projection = new String[]{
                FileColumns.DATA, FileColumns.TITLE, FileColumns.SIZE
        };
        //构造筛选语句
        String selection = "";
        for (int i = 0; i < extension.length; i++) {
            if (i != 0) {
                selection = selection + " OR ";
            }
            selection = selection + FileColumns.DATA + " LIKE '%" + extension[i] + "'";
        }
        //按时间递增顺序对结果进行排序;待会从后往前移动游标就可实现时间递减
        String sortOrder = FileColumns.DATE_MODIFIED;
        //获取内容解析器对象
        ContentResolver resolver = context.getContentResolver();
        //获取游标
        Cursor cursor = resolver.query(fileUri, projection, selection, null, sortOrder);
        if (cursor == null)
            return null;
        //游标从最后开始往前递减，以此实现时间递减顺序（最近访问的文件，优先显示）
        if (cursor.moveToLast()) {
            do {
                //输出文件的完整路径
                String path = cursor.getString(0);
                String title = cursor.getString(1);
                String size = cursor.getString(2);
                if (path != null && path.contains("/storage/emulated/0/Android/data/com.taobao.taobao/files/AVFSCache/phximgs_top3")) {
                    Log.d("taobaoPhoto", title + "size is-->>" + size + " bytes");
                    Entity entity = new Entity(title, size, path, 0, 0);
                    list.add(entity);
                    //result = result.append("图片: ").append(title).append("  大小: ").append(size).append("\n");
                } else {
                    Log.d("tag", path);
                }
            } while (cursor.moveToPrevious());
        }
        cursor.close();
        return list;
    }

    private static void getFiles(ArrayList<File> fileList, String path) {
        File[] allFiles = new File(path).listFiles();
        if (allFiles == null)
            return;
        for (int i = 0; i < allFiles.length; i++) {
            File file = allFiles[i];
            if (file.isFile() && file.getAbsolutePath().contains(".cnt")) {
                fileList.add(file);
            } else if (!file.getAbsolutePath().contains(".thumnail")) {
                getFiles(fileList, file.getAbsolutePath());
            }
        }
    }

    public static List<Entity> getInfo(boolean isFromSDCard, String... fileUrls) {
        List<Entity> list = new ArrayList<>();
        ArrayList<File> files = new ArrayList<>();
        String url;
        if (isFromSDCard) {
            url = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.taobao.taobao/files/AVFSCache/";
            for (int i = 0; i < fileUrls.length; i++) {
                url = url + fileUrls[i];
                getFiles(files, url);
            }
        } else {
            url = urlJD;
            upgradeRootPermission("/data/data/com.jingdong.app.mall");
            getFiles(files, url);
        }
        for (File file : files) {
            int size[] = getImageWidthAndHeight(file);
            Entity entity = new Entity(file.getName(), file.length() / 1024 + "", file.getAbsolutePath(), size[0], size[1]);
            list.add(entity);
        }
        return list;
    }

    public static Boolean clear(String path) {
        File file = new File(path);
        if (!file.exists())
            return true;
        if (file.isDirectory()) {
            for (File subFile : new File(path + File.separator).listFiles())
                clear(subFile.getAbsolutePath());
        } else file.delete();
        return true;
    }

    private static int[] getImageWidthAndHeight(File file) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;//这个参数设置为true才有效，
        Bitmap bmp = BitmapFactory.decodeFile(file.getAbsolutePath(), options);//这里的bitmap是个空
        if (bmp == null) {
            Log.e("通过options获取到的bitmap为空", "===");
        }
        return new int[]{options.outHeight, options.outWidth};
    }

    /**
     * 应用程序运行命令获取 Root权限，设备必须已破解(获得ROOT权限)
     *
     * @return 应用程序是/否获取Root权限
     */
    public static boolean upgradeRootPermission(String pkgCodePath) {
        Process process = null;
        DataOutputStream os = null;
        try {
            String cmd = "chmod 777 " + pkgCodePath;
            process = Runtime.getRuntime().exec("su"); //切换到root帐号
            os = new DataOutputStream(process.getOutputStream());
            os.writeBytes(cmd + "\n");
            os.writeBytes("exit\n");
            os.flush();
            process.waitFor();
        } catch (Exception e) {
            return false;
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                process.destroy();
            } catch (Exception e) {
            }
        }
        return true;
    }

    public static ArrayList execCmdsforResult(String[] cmds) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            Process process = Runtime.getRuntime().exec("su");
            OutputStream os = process.getOutputStream();
            process.getErrorStream();
            InputStream is = process.getInputStream();
            int i = cmds.length;
            for (int j = 0; j < i; j++) {
                String str = cmds[j];
                os.write((str + "\n").getBytes());
            }
            os.write("exit\n".getBytes());
            os.flush();
            os.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while (true) {
                String str = reader.readLine();
                if (str == null)
                    break;
                list.add(str);
            }
            reader.close();
            process.waitFor();
            process.destroy();
            return list;
        } catch (Exception localException) {
        }
        return list;
    }
}