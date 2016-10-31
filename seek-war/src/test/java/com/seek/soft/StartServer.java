package com.seek.soft;

import org.mortbay.jetty.Server;

/**
 * jetty启动
 *  
 * <p/>
 * 创建时间: 2014年11月10日 下午3:42:31 <br/>
 *
 * @author gfzhao
 * @version 
 * @since v0.0.1
 */
public class StartServer {

	public static final int PORT = 8081;
	public static final String CONTEXT = "/seek";
	public static final String BASE_URL = "http://localhost:8081/uc";

	public static void main(String[] args) throws Exception {
		System.setProperty("spring.profiles.active", "test");
		Server server = JettyFactory.buildNormalServer(PORT, CONTEXT);
		server.start();
		System.out.println("Server running at " + BASE_URL);
		System.out.println("Hit Enter in console to stop server");
		if (System.in.read() != 0) {
			server.stop();
            System.out.println("Server stopped");
		}
	}

}
