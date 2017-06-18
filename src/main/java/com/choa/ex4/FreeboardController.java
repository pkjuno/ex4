package com.choa.ex4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.choa.board.BoardDTO;
import com.choa.freeboard.FreeboardDTO;
import com.choa.freeboard.FreeboardServiceImpl;

@Controller
@RequestMapping(value="/freeboard/**")
public class FreeboardController {
	
	@Autowired
	private FreeboardServiceImpl freeboardService;
	
	//list
	@RequestMapping(value="freeboardList", method=RequestMethod.GET)
	public String list(Model model, @RequestParam(defaultValue="1") Integer curPage) throws Exception{
		List<BoardDTO> ar = freeboardService.boardList(curPage);
		model.addAttribute("list", ar);
		model.addAttribute("board", "freeboard");
		return "Board/BoardList";
	}
	//view
	@RequestMapping(value="freeboardView", method=RequestMethod.GET)
	public void view(Integer num, Model model){
		FreeboardDTO freeboardDTO = freeboardService.boardView(num);
		model.addAttribute("dto", freeboardDTO);
		System.out.println("뷰");
		System.out.println(freeboardDTO);
	}
	//writeForm
	@RequestMapping(value="freeboardWrite", method=RequestMethod.GET)
	public void write(Model model){
		model.addAttribute("path", "Write");
		System.out.println("작성폼");
		
	}
	//Write 처리
	@RequestMapping(value="freeboardWrite", method=RequestMethod.POST)
	public void write2(FreeboardDTO freeboardDTO){
		int result = freeboardService.freeboardWrite(freeboardDTO);
		System.out.println("작성처리");
		System.out.println(result);
	}
	//Update Form
	@RequestMapping(value="freeboardUpdate", method=RequestMethod.GET)
	public void update(Model model){
		model.addAttribute("path", "Update");
		System.out.println("업데이트폼");
	}
	//Update 처리
	@RequestMapping(value="freeboardUpdate", method=RequestMethod.POST)
	public void update2(Integer num){
		int result = freeboardService.freeboardUpdate(num);
		System.out.println("업데이트처리");
		System.out.println(result);
	}
	@RequestMapping(value="freeboardDelete", method=RequestMethod.GET)
	public void delete(Integer num){
		int result = freeboardService.freeboardDelete(num);
		System.out.println("삭제처리");
		System.out.println(result);
	}
}
