package com.springapp.mvc;

import com.alibaba.fastjson.JSONObject;
import com.springapp.mvc.util.PropertiesRead;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(value = "/printWelcome",method = RequestMethod.GET)
	public String printWelcome(ModelMap model, HttpServletResponse httpServletResponse) throws IOException {
		model.addAttribute("message", "Hello world!");

		return "hello";
	}

	@RequestMapping(value = "/vueTest")
	public String vueTest(Model model) {
		model.addAttribute("projectPath", PropertiesRead.getString("spring_mvc_path"));
		model.addAttribute("vueValue", "vueValue");

		return "vueTest";
	}


	public static void main(String[] args) throws IOException {
		List<String> test = Files.readAllLines(Paths.get("E:/new.txt"));
		Path path1 = Paths.get("E:/sdf/sdfsdf/dsf");
		File file = new File("E:/sdf/sdfsdf/dsf");
		file.mkdirs();
		File file2 = File.createTempFile("test",".txt",file);
		file2.getName();
		Files.createDirectory(path1);
		Path path = Paths.get("E:/sdf/fds/gfds.txt");
		Files.createFile(path);
		System.out.println(test);
	}
}