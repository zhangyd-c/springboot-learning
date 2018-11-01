package me.zhyd.springboot.poi.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import me.zhyd.springboot.poi.model.WordParam;

public class PoiUtil {
	//http://www.zslin.com/web/article/detail/28
	public static void build(InputStream inputStream, Map<String, Object> contentMap, String exportFile) throws Exception {
		
		// 打成jar包后会取不到模板文件，所以先这么处理
		// 先将模板上传到临时目录，然后从临时目录取就没问题了
		File file = new File("/opt/tmp/template.doc");
		FileUtil.mkdirs(file);
		FileUtil.uploadFile(inputStream, file.getAbsolutePath());
		//
		
		
		FileInputStream tempFileInputStream = new FileInputStream("/opt/tmp/template.doc");
		HWPFDocument document = new HWPFDocument(tempFileInputStream);

		// 读取文本内容
		Range bodyRange = document.getRange();
		// 替换内容
		for (Map.Entry<String, Object> entry : contentMap.entrySet()) {
			bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue().toString());
		}

		// 导出到文件
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		document.write(byteArrayOutputStream);
		write(exportFile, byteArrayOutputStream);
		document.close();
		if(file.exists()){
			file.delete();
		}
	}

	public static void build(File tmpFile, Map<String, Object> contentMap, String exportFile) throws Exception {
		FileInputStream tempFileInputStream = new FileInputStream(tmpFile);
		HWPFDocument document = new HWPFDocument(tempFileInputStream);

		// 读取文本内容
		Range bodyRange = document.getRange();
		// 替换内容
		for (Map.Entry<String, Object> entry : contentMap.entrySet()) {
			bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue().toString());
		}

		// 导出到文件
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		document.write(byteArrayOutputStream);
		write(exportFile, byteArrayOutputStream);
		document.close();
	}

	public static void buildXssf(File tmpFile, Map<String, Object> contentMap, String exportFile) throws Exception {
		FileInputStream tempFileInputStream = new FileInputStream(tmpFile);
		XWPFDocument document = new XWPFDocument(tempFileInputStream);
		// 替换段落里面的变量
		replaceInPara(document, contentMap);

		// 导出到文件
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		document.write(byteArrayOutputStream);
		write(exportFile, byteArrayOutputStream);
		document.close();
	}

	private static void write(String exportFile, ByteArrayOutputStream byteArrayOutputStream)
			throws FileNotFoundException, IOException {
		FileUtil.mkdirs(exportFile);
		OutputStream outputStream = new FileOutputStream(exportFile);
		outputStream.write(byteArrayOutputStream.toByteArray());
		outputStream.close();
	}

	/**
	 * 替换段落里面的变量
	 * 
	 * @param doc
	 *            要替换的文档
	 * @param params
	 *            参数
	 */
	private static void replaceInPara(XWPFDocument doc, Map<String, Object> params) {
		Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
		XWPFParagraph para;
		while (iterator.hasNext()) {
			para = iterator.next();
			replaceInPara(para, params);
		}
	}

	/**
	 * 替换段落里面的变量
	 * 
	 * @param para
	 *            要替换的段落
	 * @param params
	 *            参数
	 */
	private static void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
		List<XWPFRun> runs;
		Matcher matcher;
		if (matcher(para.getParagraphText()).find()) {
			runs = para.getRuns();
			for (int i = 0; i < runs.size(); i++) {
				XWPFRun run = runs.get(i);
				String runText = run.toString();
				matcher = matcher(runText);
				if (matcher.find()) {
					while ((matcher = matcher(runText)).find()) {
						runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
					}
					// 直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
					// 所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
					para.removeRun(i);
					para.insertNewRun(i).setText(runText);
				}
			}
		}
	}

	/**
	 * 正则匹配字符串
	 * 
	 * @param str
	 * @return
	 */
	private static Matcher matcher(String str) {
		Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return matcher;
	}
	
	public static String generateFileName(WordParam wordParam){
		String pattern = "员工绩效考核表_产研技术岗-{0}({1}-{2}-{3}).doc";
		return MessageFormat.format(pattern, wordParam.getName(),wordParam.getYear(),wordParam.getMonth(),wordParam.getDay());
	}
}
