package com.hsbc.cloud.poc.git;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;

/**
 * Simple snippet which shows how to clone a repository from GitHub and then
 * checkout a PR
 *
 * @author dominik.stadler at gmx.at
 */
public class CheckoutGitHubPullRequest {

	private static final String REMOTE_URL = "https://github.com/chetan-git-hub/SV-Service-Layer.git";

	public static void main(String[] args) throws IOException, GitAPIException {
		// prepare a new folder for the cloned repository
		File localPath = File.createTempFile("/home/tf", "");
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

			/*
			 * FetchResult fetchResult = result.fetch().setRemote(REMOTE_URL)
			 * .setCredentialsProvider(new UsernamePasswordCredentialsProvider(git_username,
			 * git_password)) // .setRefSpecs("+refs/pull/6/head:pr_6") .setRefSpecs(new
			 * RefSpec("+refs/heads/*:refs/heads/*")).call();
			 */
			/*
			 * System.out.println("Result when fetching the PR: " +
			 * fetchResult.getMessages());
			 * 
			 * Ref checkoutRef = result.checkout() .setName("pr_6") .call();
			 * 
			 * System.out.
			 * println("Checked out PR, now printing log, it should include two commits from the PR on top"
			 * );
			 * 
			 * Iterable<RevCommit> logs = result.log() .call(); for (RevCommit rev : logs) {
			 * System.out.println("Commit: " + rev + ", name: " + rev.getName() + ", id: " +
			 * rev.getId().getName() ); }
			 */
		}

		// clean up here to not keep using more and more disk-space for these samples
		FileUtils.deleteDirectory(localPath);
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
}