package ckhbox.villagebox.client.gui.guidebook.page;

import java.util.ArrayList;
import java.util.List;

import ckhbox.villagebox.client.gui.guidebook.GuiGuideBook;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkPro;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkText;
import ckhbox.villagebox.common.village.profession.Profession;

public class PageProList extends Page{
	
	private int pageIdx;
	private static int prosPerPage = 7;
	
	public PageProList(GuiGuideBook guiGuideBook, int pageIdx) {
		super(guiGuideBook, "Professions");
		this.pageIdx = pageIdx;
	}

	@Override
	public void onInit() {		
		List<Profession> pros = this.guiGuideBook.guidebookData.pros;
		int from = pageIdx * prosPerPage;
		int to = Math.min(pros.size(), (pageIdx + 1) * prosPerPage);
		for(int i =from;i<to;i++){
			List<String> hovertext = new ArrayList<String>();
			hovertext.add(pros.get(i).getDescription());
			this.addLink(new LinkPro(this,pros.get(i),">pro=" + pros.get(i).getRegID(),hovertext), true);
		}
		
		int top = this.guiGuideBook.getContentTop() + this.guiGuideBook.getContentHeight() - 10;
		if(this.pageIdx > 0){
			this.addLink(new LinkText(this,"<--","prolist=" + (this.pageIdx - 1),null),top,0);
		}
		int pageCount = (pros.size() - 1) / prosPerPage + 1;
		if(this.pageIdx < pageCount - 1){
			this.addLink(new LinkText(this,"-->","prolist=" + (this.pageIdx + 1),null),top,2);
		}
		
		this.addLink(new LinkText(this,"Back","back=",null),top,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
	}
	
}
