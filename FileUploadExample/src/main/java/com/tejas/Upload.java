package com.tejas;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class Upload extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> files = sfu.parseRequest(request);
			
			
			for (FileItem file: files) {
				file.write(new File("/Users/tejaskashid/tempDelete/Java/Eclipse/FileUploadExample/FilesUploaded/"+file.getName()));
			}
			
			out.println(files.size()+" files uploaded!");
		} catch (Exception e) {
			
		}
		
		
		
	}

}
