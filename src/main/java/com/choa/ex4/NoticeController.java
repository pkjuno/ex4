package com.choa.ex4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeServiceImpl;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Autowired//Inject는 데이터 타입으로 찾는다.
	private NoticeServiceImpl noticeService; 
	
	
	//list
	@RequestMapping(value="noticeList", method=RequestMethod.GET)
	public String list(Model model, @RequestParam(defaultValue="1") Integer curPage) throws Exception{
		List<BoardDTO> ar = noticeService.boardList(curPage);
		model.addAttribute("board", "notice");
		model.addAttribute("list", ar);
		return "Board/BoardList";
	}
	//view
	@RequestMapping(value="noticeView", method=RequestMethod.GET)
	public void view(Integer num, Model model) throws Exception{
		BoardDTO noticeDTO = noticeService.boardView(num);
		model.addAttribute("dto", noticeDTO);
	}
	//writeForm
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public void Write(Model model){
		model.addAttribute("path", "Write");
	}
	//write 처리
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public String Write(NoticeDTO noticeDTO, RedirectAttributes redirectAttributes) throws Exception{
		int result = noticeService.boardWrite(noticeDTO);
		String message = "FAIL";
		if(result>0){
			message = "SUCCESS";
						
		}
			
		
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:noticeList?curPage=1";
		//if 문 처리
	}
	
	//update Form
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public String update(Integer num, Model model) throws Exception{
		BoardDTO noticeDTO = new NoticeDTO();
		noticeDTO = noticeService.boardView(num);
		model.addAttribute("path", "Update");
		model.addAttribute("dto", noticeDTO);
		return "notice/noticeWrite";
	}
	
	//update 처리
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public String update(NoticeDTO noticeDTO, RedirectAttributes redirectAttributes) throws Exception{
		int result = noticeService.boardUpdate(noticeDTO);
		String message = "FAIL";
		if(result>0){
			message = "SUCCESS";
		}
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/notice/noticeList?curPage=1";
		//if 문 처리
	}
	
	//delete 처리
	@RequestMapping(value="noticeDelete", method=RequestMethod.GET)
	public String delete(Integer num, RedirectAttributes redirectAttributes) throws Exception{
		String message = "FAIL";
		int result = noticeService.boardDelete(num);
		if(result>0){
			message = "SUCCESS";
		}
		redirectAttributes.addFlashAttribute("message", message);
		
		return "redirect:/notice/noticeList?curPage=1";
				
		
		
	}
	
}