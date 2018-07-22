package com.wh.groovy.test

def tellFortunes(Closure closure){
	Date date = new Date("09/20/2012")
	Closure postFortune = closure.curry(date)
	closure.rcurry(argument)
	postFortune  "you day is filled with ceremony"
	postFortune  " they're features, not bugs"
}
tellFortunes() {date,fortune ->
		println "fortune for ${date} id '${fortune}'"
	}