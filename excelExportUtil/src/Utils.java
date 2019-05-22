import java.awt.Container;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("serial")
public class Utils extends JFrame implements ActionListener {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";
	private String startFlag = START;
	private String endFlag = END;
	private String titleStartFlag = TITLE_START;
	private String titleEndFlag = TITLE_END;
	private static final String START = "oneTimeStart";
	private static final String END = "oneTimeEnd";
	private static final String TITLE_START = ":";
	private static final String TITLE_END = "--->";
	private static final String paramTitle = "<html>参数设置<br/>-----------------------------------------------------------------------------------------------------------<br/></html>";
	private String resultExcelUrl;
	private boolean isOpen = false;
	private static final String guideStr = "<html>-----------------------------------------------------------------------------------------------------------<br/><br/><br/>参数设置说明<br/>"
			+ "<br/>2019-05-15 15:10:58.728 3981-3981/com.jingdong.app.mall D/timeCompare: oneTimeStart --->1557904258728<br/>"
			+ "<br/>2019-05-15 15:10:58.775 3981-3981/com.jingdong.app.mall D/timeCompare: request start time --->1557904258775<br/>"
			+ "<br/>2019-05-15 15:11:02.806 3981-3981/com.jingdong.app.mall D/timeCompare: oneTimeEnd --->1557904259806<br/>"
			+ "<br/>其中，x、y、m的值分别对应关系如下：<br/>" + "<br/>x → oneTimeStart（一次运行后，第一条log的描述词）<br/>"
			+ "<br/>y → oneTimeEnd（一次运行后，最后一条log的描述词）<br/>" + "<br/>m → --->（描述词的结束截取标志，同时也是时间的开始截取标志）<br/>"
			+ "</html>";
	private static final String readMeStr = "<html>请先在输入框中输入待分析的文件名称<br/>点击执行生成excel后根据提示得到选择目录下的excel文件<br/></html>";
	JLabel remind;// 输入提示框
	JTextField input;// 输入框
	JButton lookForBtn;// 浏览按钮
	JTextField showResult;// 文本框
	JLabel readme;// 使用须知
	JLabel paramSetting;// 参数设置
	JLabel startFlagLabel, endFlagLabel, titleEndFlagLabel, titleStartFlagLabel;// 参数label
	JTextField startFlagField, endFlagField, titleEndFlagField, titleStartFlagField;// 参数textField
	JButton openDefineParamBtn;// 自定义参数开启按钮
	JLabel paramDoc;// 参数设置说明文案
	JButton makeExcel;// 导出excel按钮
	JPanel panel;

	public Utils() {
		this.setVisible(true);
		this.setResizable(false);
		Container conn = getContentPane(); // 得到窗口的容器
		setLayout(null);

		remind = new JLabel("请输入log文件地址:");
		remind.setBounds(20, 10, 140, 20);
		conn.add(remind);

		input = new JTextField(20);// 输入框的初始化
		input.setBounds(15, 40, 320, 30);
		conn.add(input);

		lookForBtn = new JButton("浏览");// 浏览按钮初始化
		lookForBtn.setBounds(340, 40, 100, 30);
		lookForBtn.addActionListener(this);
		conn.add(lookForBtn);

		readme = new JLabel(readMeStr);// 使用须知
		readme.setBounds(20, 70, 390, 60);
		conn.add(readme);

		makeExcel = new JButton("导出excel");
		makeExcel.setBounds(15, 130, 120, 30);
		makeExcel.addActionListener(this);
		conn.add(makeExcel);

		openDefineParamBtn = new JButton("开启自定义参数功能");
		openDefineParamBtn.setBounds(160, 130, 180, 30);
		openDefineParamBtn.addActionListener(this);
		conn.add(openDefineParamBtn);

		setTitle("统计耗时");
		this.setSize(600, 200);
		setLocationRelativeTo(null);// 窗口居中
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBounds(0, 170, 600, 500);
		panel.setLayout(null);

		paramSetting = new JLabel(paramTitle);
		paramSetting.setBounds(20, 0, 560, 30);
		panel.add(paramSetting);

		startFlagLabel = new JLabel("请输入x：");
		startFlagLabel.setBounds(20, 40, 80, 30);
		panel.add(startFlagLabel);

		startFlagField = new JTextField(20);// 输入框的初始化
		startFlagField.setBounds(100, 40, 100, 30);
		startFlagField.setEnabled(false);
		panel.add(startFlagField);

		endFlagLabel = new JLabel("请输入y：");
		endFlagLabel.setBounds(260, 40, 80, 30);
		panel.add(endFlagLabel);

		endFlagField = new JTextField(20);// 输入框的初始化
		endFlagField.setBounds(340, 40, 100, 30);
		endFlagField.setEnabled(false);
		panel.add(endFlagField);

//		titleStartFlagLabel = new JLabel("请输入m：");
//		titleStartFlagLabel.setBounds(260, 70, 80, 30);
//		panel.add(titleStartFlagLabel);
//
//		titleStartFlagField = new JTextField(20);// 输入框的初始化
//		titleStartFlagField.setBounds(340, 70, 100, 30);
//		titleStartFlagField.setEnabled(false);
//		panel.add(titleStartFlagField);

		titleEndFlagLabel = new JLabel("请输入m：");
		titleEndFlagLabel.setBounds(20, 80, 80, 30);
		panel.add(titleEndFlagLabel);

		titleEndFlagField = new JTextField(20);// 输入框的初始化
		titleEndFlagField.setBounds(100, 80, 100, 30);
		titleEndFlagField.setEnabled(false);
		panel.add(titleEndFlagField);

		paramDoc = new JLabel(guideStr);
		paramDoc.setBounds(20, 120, 560, 360);
		panel.add(paramDoc);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		new Utils();
	}

	/**
	 * 提醒删除文件对话框
	 * 
	 * @param frame
	 * @return
	 */
	private static int popWindow(JFrame frame) {
		Object[] options = { "确定", "取消", "帮助" };
		int response = JOptionPane.showOptionDialog(frame, "如果目录下已存在该文件，则会先删除再写入，你想好了哦", "三思而后行",
				JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		return response;
	}

	/**
	 * 获得上层文件目录
	 * 
	 * @param file
	 * @return
	 */
	private static void makeParentDir(File file) {
		if (file != null) {
			File parent = new File(file.getParent());
			if (parent != null && parent.exists()) {
				if (parent.getName().equals(file.getName())) {

				}
			} else {
				if (parent.mkdir()) {
					makeParentDir(parent);
				}
			}
		} else {

		}
	}

	/**
	 * 创建新excel.
	 * 
	 * @param frame     展示的JFrame
	 * @param fileDir   excel的路径
	 * @param sheetName 要创建的表格索引
	 * @param titleRow  excel的总数据
	 */
	public static void createExcel(JFrame frame, String sheetName, ArrayList<ArrayList<String>> list) throws Exception {
		if (list == null || list.isEmpty()) {
			JOptionPane.showMessageDialog(frame, "获得的数据为空，请检查是否开启自定义参数，输入参数是否匹配", "keep smart",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		File file = selectFilesAndDir(FileDialog.SAVE, frame);
		if (file == null) {
			JOptionPane.showMessageDialog(frame, "请选择一个目标文件", "keep smart", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (file.getName().trim().isEmpty()) {
			file = new File(file.getAbsolutePath() + "result.xls");
		}
		boolean canNext = checkAndDeleteFile(file, frame);
		if (!canNext || file == null) {
			JOptionPane.showMessageDialog(frame, "excel生成中断，请正确选择重新尝试", "keep smart", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (!file.getName().contains(".")) {
			file = new File(file.getAbsolutePath() + ".xls");
		}
		if (!file.exists()) {
			makeParentDir(file);
		}
		// 创建workbook
		Workbook workbook = getWorkbook(file.getAbsolutePath());
		// 添加Worksheet（不添加sheet时生成的xls文件打开时会报错)
		Sheet sheet1 = workbook.createSheet(sheetName);
		// 新建文件
		FileOutputStream out = null;
		try {
			for (short i = 0; i < list.size(); i++) {
				// 添加行
				Row row = sheet1.createRow(i);
				ArrayList<String> data = list.get(i);// 行数据数组
				for (short j = 0; j < data.size(); j++) {
					Cell cell = row.createCell(j);
					cell.setCellValue(data.get(j));
				}
			}
			out = new FileOutputStream(file.getAbsolutePath());
			workbook.write(out);
			Object[] options = { "帮你穿越到文件目录", "我自己去开", "帮助" };
			int response = JOptionPane.showOptionDialog(frame, "excel已经自动生成，我真是牛批，文件名是:" + file.getName(), "keep smart",
					JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			switch (response) {
			case 0:
				java.awt.Desktop.getDesktop().open(file.getParentFile());
				break;
			case 1:
				JOptionPane.showMessageDialog(frame, "是个狠人,但我偏要帮你打开，不但打开我还送到你脸上", "我很中意你啊", JOptionPane.ERROR_MESSAGE);
				java.awt.Desktop.getDesktop().open(file);
				break;
			case 2:
				JOptionPane.showMessageDialog(frame, "不帮，再见", "氪金 can help you", JOptionPane.ERROR_MESSAGE);
				break;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "啊啊啊，失败了", "福报之源祝福你下次好运", JOptionPane.ERROR_MESSAGE);
			throw e;
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 判断Excel的版本,获取Workbook
	 * 
	 * @param in
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static Workbook getWorkbook(String fileName) throws IOException {
		Workbook wb = null;
		if (fileName.endsWith(EXCEL_XLS)) { // Excel&nbsp;2003
			wb = new HSSFWorkbook();
		} else if (fileName.endsWith(EXCEL_XLSX)) { // Excel 2007/2010
			wb = new XSSFWorkbook();
		}
		return wb;
	}

	private void openDefineParam(boolean open) {
		if (open) {
			add(panel);
			this.setSize(600, 700);

			startFlagField.setEnabled(true);
			endFlagField.setEnabled(true);
//			titleStartFlagField.setEnabled(true);
			titleEndFlagField.setEnabled(true);

			openDefineParamBtn.setText("关闭自定义参数功能");
			startFlagField.setText("");
			endFlagField.setText("");
//			titleStartFlagField.setText("");
			titleEndFlagField.setText("");
		} else {
			remove(panel);
			this.setSize(600, 200);

			startFlagField.setEnabled(false);
			endFlagField.setEnabled(false);
//			titleStartFlagField.setEnabled(false);
			titleEndFlagField.setEnabled(false);

			openDefineParamBtn.setText("开启自定义参数功能");
			startFlagField.setText(START);
			endFlagField.setText(END);
//			titleStartFlagField.setText(TITLE_START);
			titleEndFlagField.setText(TITLE_END);
		}
	}

	/**
	 * 设置遍历节点参数
	 * 
	 * @param open
	 */
	private void resetParam(boolean open) {
		if (open) {
			startFlag = startFlagField.getText().trim();
			endFlag = endFlagField.getText().trim();
//			titleStartFlag = titleStartFlagField.getText().trim();
			titleEndFlag = titleEndFlagField.getText().trim();
		} else {
			startFlag = START;
			endFlag = END;
//			titleStartFlag = TITLE_START;
			titleEndFlag = TITLE_END;
		}
	}

	/**
	 * 防止误删文件的check
	 * 
	 * @param file
	 * @param frame
	 * @return 是否可以进行下一步
	 */
	private static boolean checkAndDeleteFile(File file, JFrame frame) {
		boolean flag = true;
		if (file.exists()) {
			int result = popWindow(frame);
			switch (result) {
			case 0:
				flag = true;
				file.delete();
				break;
			case 1:
				flag = false;
				break;
			case 2:
				JOptionPane.showMessageDialog(frame, "充钱才能让你变得更强", "氪金 can help you", JOptionPane.ERROR_MESSAGE);
				flag = false;
				break;
			}
		}
		return flag;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (makeExcel == e.getSource()) {
			resultExcelUrl = input.getText().trim();
			resetParam(isOpen);
			try {
				createExcel(this, "result", collectData(resultExcelUrl));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (lookForBtn == e.getSource()) {
			File file = selectFilesAndDir(FileDialog.LOAD, this);
			if (file == null)
				return;
			resultExcelUrl = file.getAbsolutePath();
			input.setText(resultExcelUrl);
		} else if (openDefineParamBtn == e.getSource()) {
			isOpen = !isOpen;
			openDefineParam(isOpen);
		}
	}

	public ArrayList<ArrayList<String>> collectData(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			JOptionPane.showMessageDialog(this, "文件不存在，请确认再输入一遍", "keep smart", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> title = new ArrayList<String>();
		FileReader fr;
		ArrayList<String> data = null;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str;
			while ((str = br.readLine()) != null) {
				String time = str.substring(str.indexOf(titleEndFlag) + titleEndFlag.length()).trim();
				if (str.contains(startFlag)) {
					data = new ArrayList<String>();
				}
				if (data == null)
					return list;
				data.add(time);
				if (list.isEmpty()) {
					title.add(str.substring(str.lastIndexOf(titleStartFlag) + 1, str.indexOf(titleEndFlag)).trim());
				}
				if (str.contains(endFlag)) {
					if (list.isEmpty()) {
						list.add(title);
					}
					list.add(data);
				}
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "目标文件未找到", "keep smart", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "io过程出错", "keep smart", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (StringIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(this, "如果开启了自定义参数，请完成所有输入后再执行导出excel（注：参数不能为空格，否则视为未输入）", "keep smart",
					JOptionPane.ERROR_MESSAGE);
		}
		return list;
	}

	/**
	 * 选择路径或文件
	 * 
	 * @return
	 */
	public static File selectFilesAndDir(int type, JFrame frame) {
//		JFileChooser jfc = new JFileChooser();
//		// 设置当前路径为桌面路径,否则将我的文档作为默认路径
//		FileSystemView fsv = FileSystemView.getFileSystemView();
//		jfc.setCurrentDirectory(fsv.getHomeDirectory());
//		// JFileChooser.FILES_AND_DIRECTORIES 选择路径和文件
//		jfc.setFileSelectionMode(type);
//		// 弹出的提示框的标题
//		jfc.showDialog(new JLabel(), "确定");
//		// 用户选择的路径或文件
//		File file = jfc.getSelectedFile();
		String remind = "";
		if (type == FileDialog.LOAD) {
			remind = "打开log文件";
		} else {
			remind = "保存为";
		}
		FileDialog fileDialog = new FileDialog(frame, remind, type);
		fileDialog.setDirectory(".");
		fileDialog.setVisible(true);
		if (fileDialog.getDirectory() == null) {
			return null;
		}
		if (fileDialog.getFile() == null) {
			return null;
		}
		File file = new File(fileDialog.getDirectory() + fileDialog.getFile());
		return file;
	}
}
