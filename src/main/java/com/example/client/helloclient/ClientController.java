package com.example.client.helloclient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@RestController
@RequestMapping("/rest")
public class ClientController {

	// @Autowired
	// private RestTemplate restTemplate;
	// @LogExecutionTime
	@RequestMapping(value = "/hi", method = RequestMethod.GET, produces = "application/json")
	public String hi() {
		try {
			JSch jsch = new JSch();

			String user = "ec2-user";
			String host = "18.216.121.21";
			int port = 22;
			String privateKey = "C:\\Users\\g521784\\Desktop\\db.pem";

			jsch.addIdentity(privateKey);
			System.out.println("identity added ");

			Session session = jsch.getSession(user, host, port);
			System.out.println("session created.");

			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);

			session.connect();

			Channel channel = session.openChannel("shell");

			// Enable agent-forwarding.
			// ((ChannelShell)channel).setAgentForwarding(true);

			channel.setInputStream(System.in);

			channel.setOutputStream(System.out);

			// channel.connect();
			channel.connect(3 * 1000);
		} catch (Exception e) {
			System.out.println(e);
		}

		return new String("Hi client");

	}

	/*
	 * @RequestMapping(value = "/list", method= RequestMethod.GET) public
	 * List<Employee> list(Employee emp){ List<Employee> emplist = new
	 * ArrayList<>(); emplist.add(new Employee("Nikhil",1,"DigitalLab"));
	 * emplist.add(new Employee("Akhil",2,"Digital")); emplist.add(new
	 * Employee("Goy",3,"Digital"));
	 * 
	 * return emplist; }
	 */

	/*
	 * @HystrixCommand(fallbackMethod = "fallback", groupKey = "Hello", commandKey =
	 * "hello", threadPoolKey = "helloThread" )
	 * 
	 * @GetMapping public String hello() { String url =
	 * "http://hello-server/rest/hello/server"; return
	 * restTemplate.getForObject(url, String.class); } public String
	 * fallback(Throwable hystrixCommand) { return "Circuit break"; }
	 */

}