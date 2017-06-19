package com.choa.ex4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public void view(Integer num, Model model) throws Exception{
		BoardDTO boardDTO = new FreeboardDTO();
		boardDTO = freeboardService.boardView(num);
		model.addAttribute("dto", boardDTO);
		model.addAttribute("board", "freeboard");
		System.out.println("뷰");
	}
	//writeForm
	@RequestMapping(value="freeboardWrite", method=RequestMethod.GET)
	public void write(Model model){
		model.addAttribute("path", "Write");
		System.out.println("작성폼");
		
	}
	//Write 처리
	@RequestMapping(value="freeboardWrite", method=RequestMethod.POST)
	public String write(FreeboardDTO freeboardDTO, RedirectAttributes redirectAttributes) throws Exception{
		int result = freeboardService.boardWrite(freeboardDTO);
		String message = "FAIL";
		if(result>0){
			message="SUCEESS";
		}
		
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:freeboardList?curPage=1";
	}
	//Update Form
	@RequestMapping(value="freeboardUpdate", method=RequestMethod.GET)
	public String update(Integer num, Model model) throws Exception{
		BoardDTO freeboardDTO = new FreeboardDTO();
		freeboardDTO = freeboardService.boardView(num);
		model.addAttribute("dto", freeboardDTO);
		model.addAttribute("path", "Update");
		System.out.println("업데이트폼");
		return "freeboard/freeboardWrite";
	}
	//Update 처리
	@RequestMapping(value="freeboardUpdate", method=RequestMethod.POST)
	public String update(FreeboardDTO boardDTO , RedirectAttributes redirectAttributes) throws Exception{
		int result = freeboardService.boardUpdate(boardDTO);
		String message = "FAIL";
		if(result>0){
			message = "SUCCESS";
		}
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/freeboard/freeboardList?curPage=1";
		
	}
	@RequestMapping(value="freeboardDelete", method=RequestMethod.GET)
	public String delete(Integer num, RedirectAttributes redirectAttributes) throws Exception{
		int result = freeboardService.boardDelete(num);
		String message = "FAIL";
		if(result>0){
			message = "SUCCESS";
		}
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/freeboard/freeboardList?curPage=1";
	}
}
