package com.hsbc.cloud.poc.git;
import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.*;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;

/*
* To push the code in git repo first checkout the repo in local system and then get access to that repo for git push/commit
* after that try to submit.
* */
public class PushToGit {

    @Autowired
    private static ConfigUtility configUtil;

    private static final String REMOTE_URL = "https://github.com/chetan-git-hub/SV-Service-Layer.git";
    
    public static void pushToRepo() {
        try {

        	//########### GIT CLONE #########
        	// prepare a new folder for the cloned repository
    		File localPath = File.createTempFile("TFGIT", "");
    		if (!localPath.delete()) {
    			throw new IOException("Could not delete temporary file " + localPath);
    		}

    		// then clone

    		String git_username = "chetan-git-hub";
    		String git_password = "DevSarojSai@mail";

    		System.out.println("Cloning from " + REMOTE_URL + " to " + localPath);
    		try (Git result = Git.cloneRepository().setURI(REMOTE_URL)
    				.setCredentialsProvider(new UsernamePasswordCredentialsProvider(git_username, git_password))
    				.setDirectory(localPath).setProgressMonitor(new SimpleProgressMonitor()).call()) {
    			// Note: the call() returns an opened repository already which needs to be
    			// closed to avoid file handle leaks!
    			    			
    			System.out.println("Having repository: " + result.getRepository().getDirectory());
    		
    		}
    		
    		File copied = new File(
				      "/tmp/main.tf");
			
			FileUtils.copyFileToDirectory(copied, localPath);
			
    		        	
    		//########### GIT PUSH #########
        	
			Git git = Git.open(new File(localPath.getAbsolutePath()));

            // Stage all files in the repo including new files
            git.add().addFilepattern(".").call();

            // and then commit the changes.
            git.commit()
                    .setMessage("Commit all changes including additions")
                    .call();

            // add remote repo:
            RemoteAddCommand remoteAddCommand = git.remoteAdd();
            remoteAddCommand.setName("origin");
            //remoteAddCommand.setUri(new URIish("https://github.com/pnkjkumar07/uicloudtf.git")); //working
            //remoteAddCommand.setUri(new URIish("https://github.com/hiteshcloudwork/platformui.git")); //checking
            String git_remote_url = null;
            if(null == configUtil){
                git_remote_url = "https://github.com/chetan-git-hub/hello-world.git";
            } else{
                git_remote_url = configUtil.getProperty("git_remote_url");
            }
            remoteAddCommand.setUri(new URIish(git_remote_url)); //checking
            remoteAddCommand.call();

            // push to remote:
            PushCommand pushCommand = git.push();
           // pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider("pnkjkumar07", "A$tomate1")); //working
            //String git_username = null;
            //String git_password = null;
            if(configUtil == null){
                git_username = "chetan-git-hub";
                git_password = "DevSarojSai@mail";
            } else {
                git_username = configUtil.getProperty("git_username");
                git_password = configUtil.getProperty("git_password");
            }
            System.out.println("git_remote_url="+git_remote_url + "\r\n git_username = "+git_username +"\r\n git_password = "+git_password);
            pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(git_username, git_password)); //checking
            pushCommand.call();
            
         // clean up here to not keep using more and more disk-space for these samples
    		FileUtils.deleteDirectory(localPath);
    		
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static class SimpleProgressMonitor implements ProgressMonitor {
		@Override
		public void start(int totalTasks) {
			System.out.println("Starting work on " + totalTasks + " tasks");
		}

		@Override
		public void beginTask(String title, int totalWork) {
			System.out.println("Start " + title + ": " + totalWork);
		}

		@Override
		public void update(int completed) {
			System.out.print(completed + "-");
		}

		@Override
		public void endTask() {
			System.out.println("Done");
		}

		@Override
		public boolean isCancelled() {
			return false;
		}
	}

    public static void main(String[] args) {
        pushToRepo();
    }
}