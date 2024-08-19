package com.AI_Security.AI_Security_client.utils;

import cn.hutool.core.io.resource.ClassPathResource;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class WordUtils {
    public static void generateWord(Map<String, Object> dataMap, String fileName, String ftlPath, String ftlName) throws Exception {
        Configuration configuration = new Configuration(new Version("2.3.28"));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setDirectoryForTemplateLoading(new File(new ClassPathResource(ftlPath).getUrl().getFile()));
        Template t = configuration.getTemplate(ftlName, "UTF-8");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(new ClassPathResource(fileName).getUrl().getFile())), "UTF-8"));
        t.process(dataMap, out);
        out.flush();
        out.close();
    }

    public static void zipFileTree(File sourceFile, String format, HttpServletResponse response) throws IOException {
        ZipOutputStream zipOutputStream = null;
        try {
            response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode("漏洞报告模板.docx", "UTF-8") + "\"");
            zipOutputStream = new ZipOutputStream(response.getOutputStream());
            zip(sourceFile, zipOutputStream, "");
        } finally {
            if (null != zipOutputStream) {
                try {
                    zipOutputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void zip(File file, ZipOutputStream zipOutputStream, String relativePath)
            throws IOException {
        FileInputStream fileInputStream = null;
        try {
            if (file.isDirectory()) {
                // 当前文件夹下的所有文件
                File[] list = file.listFiles();
                if (null != list) {
                    relativePath += (relativePath.length() == 0 ? "" : "/") + file.getName();
                    for (File f : list) {
                        zip(f, zipOutputStream, relativePath);
                    }
                }
            } else {
                relativePath += (relativePath.length() == 0 ? "" : "/") + file.getName();
                String tmp = relativePath.substring(relativePath.indexOf("/") + 1, relativePath.length());
                zipOutputStream.putNextEntry(new ZipEntry(tmp));
                fileInputStream = new FileInputStream(file);
                int readLen;
                byte[] buffer = new byte[1024];
                while ((readLen = fileInputStream.read(buffer)) != -1) {
                    zipOutputStream.write(buffer, 0, readLen);
                }
                zipOutputStream.closeEntry();
            }
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
