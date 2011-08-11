package net.pureessence

import groovy.swing.SwingBuilder

import java.awt.BorderLayout as BL

import javax.swing.ImageIcon
import javax.swing.WindowConstants as WC

def base = 'http://chart.apis.google.com/chart?'

def params = [cht:'p3',chs:'250x100',
              chd:'t:60,40',chl:'Hello|World']

def url = base + params.collect { k,v -> "$k=$v" }.join('&')

assert params.collect { k,v -> "$k=$v" } == 
	["cht=p3", "chs=250x100", "chd=t:60,40", "chl=Hello|World"]

assert url == 'http://chart.apis.google.com/chart?cht=p3&chs=250x100&chd=t:60,40&chl=Hello|World'

SwingBuilder.build() {
    frame(title:'Hello, World!',
        visible:true, defaultCloseOperation:WC.EXIT_ON_CLOSE) {
            label(icon:new ImageIcon(url.toURL()),constraints:BL.CENTER)
    }.pack()
}
