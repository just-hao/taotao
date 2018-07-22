package com.wh.groovy.test

import java.awt.FlowLayout
import java.awt.event.ActionListener
import java.awt.event.FocusListener
import java.awt.event.MouseListener

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.WindowConstants

frame = new JFrame(size: [300,300],
	layout: new FlowLayout(),
		defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE)
button = new JButton("click")
positionLabel = new JLabel()
msgLabel = new JLabel("")
frame.contentPane.add button
frame.contentPane.add positionLabel
frame.contentPane.add msgLabel

button.addActionListener( 
	{JOptionPane.showMessageDialog(frame, "you clicked")}as ActionListener
	)
dispMouseLocation = {positionLabel.setText("$it.x, $it.y")}	
frame.addMouseListener(dispMouseLocation as MouseListener)
frame.addMouseMotionListener(dispMouseLocation as MouseListener)
handleFocus = [
	focusGained : {msgLabel.setText("cood to see you!")},
	focusLost : {msgLabel.setText("come back soon!")}
]
button.addFocusListener(handleFocus as FocusListener)
events = ['windowsListener','ComponentListenter']
//上面的列表可能是动态的，而且可能来自某些输入
handler = {msgLabel.setText("$it")}
for (event in events) {
	handlerimpl = handler.asType(Class.forName("java.awt.event.${event}"))
	frame."add${event}"(handlerimpl)
}
frame.showWithParent
