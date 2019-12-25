package com.numberone.common.utils.file;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.numberone.common.config.Global;
import com.numberone.common.exception.file.FileNameLengthLimitExceededException;
import com.numberone.common.exception.file.FileSizeLimitExceededException;
import com.numberone.common.utils.DateUtils;
import com.numberone.common.utils.Md5Utils;

/**
 * 文件上传工具类
 * 
 * @author numberone
 */
public class MsdsFileUploadUtils {
	/**
	 * 默认大小 10M
	 */
	public static final long DEFAULT_MAX_SIZE = 10 * 1024 * 1024;

	/**
	 * 默认的文件名最大长度 100
	 */
	public static final int DEFAULT_FILE_NAME_LENGTH = 100;

	/**
	 * 默认上传的地址
	 */
	private static String defaultBaseDir = Global.getProfile();


	private static int counter = 0;

	/**
	 * 文件上传
	 *
	 * @param baseDir
	 *            相对应用的基目录
	 * @param file
	 *            上传的文件
	 * @param extension
	 *            上传文件类型
	 * @return 返回上传成功的文件名
	 * @throws FileSizeLimitExceededException
	 *             如果超出最大大小
	 * @throws FileNameLengthLimitExceededException
	 *             文件名太长
	 * @throws IOException
	 *             比如读写文件出错时
	 */
	public static final String upload(String baseDir, MultipartFile file, String extension,String material)
			throws FileSizeLimitExceededException, IOException, FileNameLengthLimitExceededException {

		int fileNamelength = file.getOriginalFilename().length();
		if (fileNamelength > FileUploadUtils.DEFAULT_FILE_NAME_LENGTH) {
			throw new FileNameLengthLimitExceededException(FileUploadUtils.DEFAULT_FILE_NAME_LENGTH);
		}

		assertAllowed(file);

		String fileName = extractFilename(file, extension,material);

		File desc = getAbsoluteFile(baseDir, baseDir + fileName);
		file.transferTo(desc);
		return fileName;
	}

	public static final String extractFilename(MultipartFile file, String extension,String material) {
		String filename = file.getOriginalFilename();
		// 20190604上傳之後取源文件名
		 filename = material+"_"+filename;
		 //+ extension;
		 System.out.println(filename);
		return filename;
	}

	public static final File getAbsoluteFile(String uploadDir, String filename) throws IOException {
		File desc = new File(File.separator + filename);

		if (!desc.getParentFile().exists()) {
			desc.getParentFile().mkdirs();
		}
		if (!desc.exists()) {
			desc.createNewFile();
		}
		return desc;
	}

	/**
	 * 编码文件名
	 */
	public static final String encodingFilename(String filename) {
		filename = filename.replace("_", " ");
		filename = Md5Utils.hash(filename + System.nanoTime() + counter++);
		return filename;
	}

	/**
	 * 文件大小校验
	 *
	 * @param file
	 *            上传的文件
	 * @return
	 * @throws FileSizeLimitExceededException
	 *             如果超出最大大小
	 */
	public static final void assertAllowed(MultipartFile file) throws FileSizeLimitExceededException {
		long size = file.getSize();
		if (DEFAULT_MAX_SIZE != -1 && size > DEFAULT_MAX_SIZE) {
			throw new FileSizeLimitExceededException(DEFAULT_MAX_SIZE / 1024 / 1024);
		}
	}
}

