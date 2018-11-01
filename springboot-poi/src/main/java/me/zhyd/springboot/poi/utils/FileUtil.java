package me.zhyd.springboot.poi.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class FileUtil {

	public static ResponseEntity<byte[]> download(String fileName, File file) throws IOException {
		return download(fileName, FileUtils.readFileToByteArray(file));
	}

	public static ResponseEntity<byte[]> download(String fileName, byte[] bs) throws IOException {
		String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", dfileName);
		return new ResponseEntity<byte[]>(bs, headers, HttpStatus.CREATED);
	}

	public static void mkdirs(String exportFile) {
		File file = new File(exportFile);
		mkdirs(file);
	}

	public static void mkdirs(File file) {
		if (!file.exists()) {
			if (file.isDirectory()) {
				file.mkdirs();
			} else {
				file.getParentFile().mkdirs();
			}
		}
	}

	public static void showAllFiles(String path) {
		File file = new File(path);
		if (file.exists()) {
			if (file.isDirectory()) {
				for (File f : file.listFiles()) {
					showAllFiles(f.getAbsolutePath());
				}
			} else {
				System.out.println(file.getAbsolutePath());
			}
		} else {
			System.out.println("文件不存在");
		}
	}

	public static boolean uploadFile(InputStream is, String filePath) {
		boolean retCode = false;
		byte[] buffer = new byte[1024];
		FileOutputStream fos = null;
		try {
			File file = new File(filePath);
			if (!file.exists())
				file.createNewFile();
			fos = new FileOutputStream(file);
			int n = -1;
			while ((n = is.read(buffer, 0, buffer.length)) != -1) {
				fos.write(buffer, 0, n);
			}
			retCode = true;
			System.out.println("upload file success...");
		} catch (FileNotFoundException fnfe) {
			System.out.println("fnfe:" + fnfe);
		} catch (IOException ioe) {
			System.out.println("ioe:" + ioe);
		} finally {
			if (fos != null) {
				try {
					fos.close();
					fos = null;
				} catch (IOException e) {
				}
			}
			if (is != null) {
				try {
					is.close();
					is = null;
				} catch (IOException e) {
				}
			}
		}

		return retCode;
	}
}
