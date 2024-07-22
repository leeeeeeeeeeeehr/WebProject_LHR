package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class FileUtil {
	
	public static String uploadFile(HttpServletRequest req, String sDirectory)
											throws ServletException, IOException {
		
		// 서버에 파일 저장
		Part part = req.getPart("ofile");

		// 헤더값을 통해 원본 파일명 가져오기
		String partHeader = part.getHeader("content-disposition");
		System.out.println("partHeader=" + partHeader);
		
		// 파일명 분리해서 배열에 넣기
		String[] phArr = partHeader.split("filename=");
		// 파일명에 붙은 "" 없애기
		String originalFileName = phArr[1].trim().replace("\"", "");
		
		// 전송된 파일이 있으면 서버 디렉토리에 저장
		if (!originalFileName.isEmpty()) {
			part.write(sDirectory + File.separator + originalFileName);
		}
		// 원본 파일명 반환
		return originalFileName;
	}
	
	
	// 서버에 저장된 파일명 변경
	public static String renameFile(String sDirectory, String fileName) {
		
		// 확장자 잘라내기
		String ext = fileName.substring(fileName.lastIndexOf("."));
		// 업로드 시간으로 파일명 변경
		String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
		// 파일명 + 확장자
		String newFileName = now + ext;
		
		// 원본 파일명과 새로운 파일명을 이용해서 File 인스턴스 생성
		File oldFile = new File(sDirectory + File.separator + fileName);
		File newFile = new File(sDirectory + File.separator + newFileName);
		// 원본 파일명을 새로운 파일명으로 변경
		oldFile.renameTo(newFile);
		
		// 새로운 파일명 반환
		return newFileName;
	}
	
	public static void download(HttpServletRequest req, HttpServletResponse resp,
            						String directory, String sfileName, String ofileName) {
		
		// 파일의 물리적인 경로 가져오기
        String sDirectory = req.getServletContext().getRealPath(directory);
        
        try {
            // 파일을 찾아 입력 스트림 생성
            File file = new File(sDirectory, sfileName);
            InputStream iStream = new FileInputStream(file);

            // 한글 파일명 깨짐 방지
            String client = req.getHeader("User-Agent");
            if (client.indexOf("WOW64") == -1) {
                ofileName = new String(ofileName.getBytes("UTF-8"), "ISO-8859-1");
            }
            else {
                ofileName = new String(ofileName.getBytes("KSC5601"), "ISO-8859-1");
            }

            // 파일 다운로드용 응답 헤더 설정
            resp.reset();
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition", "attachment; filename=\"" + ofileName + "\"");
            resp.setHeader("Content-Length", "" + file.length());

            // 새로운 출력 스트림 생성
            OutputStream oStream = resp.getOutputStream();

            // 출력 스트림에 파일 내용 출력
            byte b[] = new byte[(int)file.length()];
            int readBuffer = 0;
            while ((readBuffer = iStream.read(b)) > 0) {
                oStream.write(b, 0, readBuffer);
            }

            // 입력, 출력 스트림 닫음
            iStream.close();
            oStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("예외가 발생하였습니다.");
            e.printStackTrace();
        }
    }
	
	// 파일 삭제하기
	public static void deleteFile(HttpServletRequest req, String directory, String filename) {
		
		// 업로드 디렉토리의 물리적 경로 확인
		String sDirectory = req.getServletContext().getRealPath(directory);
		// 매개변수로 전달된 파일명과 합쳐서 file 인스턴스 명령 생성
		File file = new File(sDirectory + File.separator + filename);
		// 파일이 존재하는지 확인 후 삭제 처리
		if (file.exists()) {
			file.delete();
		}
	}
}
