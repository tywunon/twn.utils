package twn.ui.searchField;

import java.awt.Dimension;
import java.awt.event.FocusEvent;

import javax.swing.JLayeredPane;
import javax.swing.OverlayLayout;

import twn.ui.LabeledTextField;

public class SearchField extends LabeledTextField {
	private static final long serialVersionUID = 1512201384940392521L;
	
	JLayeredPane searchPreview;
	
	public SearchField() {
		this("Suche");
	}
	
	public SearchField(String label) {
		super(label);
		
		searchPreview = new JLayeredPane();
		searchPreview.setPreferredSize(new Dimension(50,150));
		searchPreview.setLayout(new OverlayLayout(searchPreview));
		add(searchPreview);
	}
	
	@Override
	protected void processFocusEvent(FocusEvent e) {
		super.processFocusEvent(e);
		if(e.getID() == FocusEvent.FOCUS_GAINED){
			searchPreview.setVisible(true);
		} else if(e.getID() == FocusEvent.FOCUS_LOST){
			searchPreview.setVisible(false);
		}
	}
}
