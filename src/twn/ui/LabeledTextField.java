package twn.ui;

import java.awt.Color;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

public class LabeledTextField extends JTextField{
	private static final long serialVersionUID = 1L;
	
	String labelText;
	Color labelTextColor;
	Color foreGroundColor;
	
	public LabeledTextField(){
		this("Label");
	}
	
	public LabeledTextField(String labelText) {
		this(labelText, Color.GRAY);
	}
	
	public LabeledTextField(String labelText, Color labelTextColor){
		this.labelText = labelText;
		this.labelTextColor = labelTextColor;
		setDefault(true);
	}
	
	public void setLabelText(String labelText){
		this.labelText = labelText;
	}
	
	public void setLabelTextColor(Color labelTextColor){
		this.labelTextColor = labelTextColor;
	}
	
	private final void setDefault(boolean deafult){
		if(deafult) {
			setText(labelText);
			foreGroundColor = getForeground();
			setForeground(labelTextColor);
		} else {
			setText("");
			setForeground(foreGroundColor);
		}
	}
	
	@Override
	protected void processFocusEvent(FocusEvent e) {
		if(e.getID() == FocusEvent.FOCUS_GAINED) {
			setDefault(false);
		} else if(e.getID() == FocusEvent.FOCUS_LOST && getText().equals("")) {
			setDefault(true);
		}
		super.processFocusEvent(e);
	}
	
	
}
