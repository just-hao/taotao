package com.wh.groovy.test

class TestDemo01 {
	
	static void main(String[] args){
		G20180610 g1 = new G20180610({println "Calculat0r 1"})
		def aCalculator ={ println "calculator 2"}
		def g2 = new G20180610(aCalculator)
		def g3 = new G20180610(aCalculator)
		g1.simulate()
		g2.simulate()
		g3.simulate()
//		g.pickEven(10, {println it})
		def a = "haha"
		a = "$a 1"
		println "1235 ${a.toString()}"
		g1.tellFortunes() {date,fortune ->
			println "fortune for ${date} id '${fortune}'"
		}
	} 
}
