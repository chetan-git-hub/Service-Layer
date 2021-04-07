package com.hsbc.cloud.poc.git;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GenerateFinalTerraForm {

    @Autowired
    private static ConfigUtility configUtil;

    public static void writeToTempFile(Object xmlData, String fileName){
        String filePath = "/tmp/"+fileName;
        System.out.println("configUtil = "+configUtil);
		/*
		 * if(null == configUtil){ filePath = "/home/tf/main.tf"; } else { filePath =
		 * configUtil.getProperty("git_main_tf_filepath"); }
		 */
        

        System.out.println("FilePath to write main.tf= "+filePath);
        try {
        FileOutputStream fout = new FileOutputStream(new File((filePath)));
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(xmlData);
        oos.close();
        fout.close();
        System.out.println("Writting tf file path:- "+filePath);
        //System.out.println(xmlData);

        }catch(IOException e) {
			// TODO: handle exception
		}
    }
}