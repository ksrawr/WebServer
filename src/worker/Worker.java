package worker;

import configurationReader.HttpdConf;
import configurationReader.MimeTypes;
import log.Logger;
import request.Request;
import resource.Resource;
import responses.Response;
import responses.ResponseFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Worker extends Thread {
	
	private Socket client;
	private MimeTypes mimes;
	private HttpdConf config;
	private BufferedReader input = null;
	
	public Worker( Socket socket, HttpdConf config, MimeTypes mimes) throws IOException {
		this.client = socket;
		this.config = config;
		this.mimes = mimes;
		
		this.openSocketInputStream();	
	}
	
	public void openSocketInputStream() throws IOException {
		input = new BufferedReader(new InputStreamReader(client.getInputStream())); 
	}
	
	public void run() {
		ResponseFactory responseFactory= new ResponseFactory();
		Request request = new Request(this.client.getInputStream());
	}
	
}
