import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BabelCT {

	public static void main(String[] arg) {
		System.out.println("请输入完整的文件路径：");
		Scanner scanner = new Scanner(System.in);
		long lastTime = 0;
		while (scanner.hasNext()) {
			String path = scanner.next();
			if (":exit".equals(path)) {
				scanner.close();
				break;
			}
			File file = new File(path);
			if (!file.exists()) {
				System.out.println("文件不存在请重新输入：");
				continue;
			}
			long[] avgTime = cBabel(path);
			if (lastTime != 0) {
				System.out.println("相比上次减少了：" + (avgTime[0] - lastTime) + "ms,优化了%.2f");
			}
			lastTime = avgTime[0];
		}
		System.out.println("辛苦啦！！！！！");
	}

	public String run(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			return "文件不存在请重新输入";
		}
		long[] result = cBabel(fileName);
		return "总耗时平均值：" + result[0] + " ms 主接口耗时：" + result[1] + " ms";
	}

	private static long[] cBabel(String fileName) {
		long[] result = new long[2];
		List<Long> allTimeList = new LinkedList<>();
		List<Long> netTimeList = new LinkedList<>();
		File file = new File(fileName);
		long startTime = 0;
		boolean tag = false;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str;
			while ((str = br.readLine()) != null) {
				if (str.contains("click time")) {
					String startStr = str.substring(str.indexOf("---->") + 6).trim();
					startTime = Long.valueOf(startStr);
					if (startTime > 0) {
						tag = true;
					}
				} else if (tag && str.contains("page finish")) {
					String finishStr = str.substring(str.indexOf("---->") + 6).trim();
					long end = Long.valueOf(finishStr);
					allTimeList.add(end - startTime);
					tag = false;
				} else if (str.contains("net finish")) {
					String netStr = str.substring(str.indexOf("---->") + 6).trim();
					netTimeList.add(Long.valueOf(netStr));
				}
			}
			result[0] = avg(allTimeList);
			result[1] = avg(netTimeList);
			return result;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static long avg(List<Long> data) {
		long result;
		long max = 0;
		long min = 0;
		if (data.size() == 0) {
			return 0;
		}
		min = data.get(0);
		long count = 0;
		for (Long value : data) {
			count += value;
			if (value > max) {
				max = value;
			}
			if (value < min) {
				min = value;
			}
		}
		if (data.size() > 5) {
			result = (count - max - min) / (data.size() - 2);
			System.out.println("一共" + data.size() + "组去除一个最大值：" + max + ",去除一个最小值：" + min + ",  平均值：" + result + "ms");
		} else {
			result = count / data.size();
			System.out.println("一共" + data.size() + "组, 平均值：" + result + "ms");
		}
		return result;
	}
}
