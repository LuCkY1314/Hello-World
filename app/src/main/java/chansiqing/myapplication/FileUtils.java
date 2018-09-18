package chansiqing.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Files.FileColumns;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileUtils {
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
                    Entity entity = new Entity(title, size, path);
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
        for (int i = 0; i < allFiles.length; i++) {
            File file = allFiles[i];
            if (file.isFile()) {
                fileList.add(file);
            } else if (!file.getAbsolutePath().contains(".thumnail")) {
                getFiles(fileList, file.getAbsolutePath());
            }
        }
    }

    public static List<Entity> getInfo() {
        List<Entity> list = new ArrayList<>();
        String url = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.taobao.taobao/files/AVFSCache/phximgs_top3";
        ArrayList<File> files = new ArrayList<>();
        getFiles(files, url);
        for (File file : files) {
            Entity entity = new Entity(file.getName(), file.length() + "", file.getAbsolutePath());
            list.add(entity);
        }
        return list;
    }
}