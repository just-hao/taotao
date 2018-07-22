import groovy.transform.Immutable

def pickEven(n, block){
	for(int i=2; i<=n; i += 2){
		block(i);
	}
}

/*def calculator
G20180610(clac){ calculator = clac }
def simulate(){
	println "running simulation"
	calculator()
}*/

def static user(closure){
}

def tellFortunes(closure){
	Date date = new Date("09/20/2012")
	postFortune = closure.curry(date)
	postFortune  "you day is filled with ceremony"
	postFortune  " they're features, not bugs"
}

def timeIt(length, closure){
	long start = System.nanoTime()
	println "max revenue for $length is ${closure(length)}"
	long end = System.nanoTime()
	println "Time taken ${(end - start)/1.0e9} seconds"
}

def rodPrices = [0,1,3,4,5,8,9,11,12,14,
	15,15,16,18,19,15,20,21,22,24,
	25,24,26,28,29,35,37,38,39,40]

def desiredLength = 27

@Immutable
class RevenueDetails {
	int revenue
	ArrayList splits
}

/*def cutRod(prices, length){
	if(length == 0){
		new RevenueDetails(0,[])
	}
	else{
		def maxRevenueDetails = new RevenueDetails(Integer.MIN_VALUE,[])
		for(rodSize in 1..length){
			def revenueFromSecondHalf = cutRod(prices, length - rodSize)
			def potentialRevenue = new RevenueDetails(
				price[rodSize] + revenueFromSecondHalf.revenue, 
				revenueFromSecondHalf.splits + rodSize)
			if(potentialRevenue.revenue > maxRevenueDetails.revenue)
				maxRevenueDetails = potentialRevenue
		}
		maxRevenueDetails
	}
}*/

def cutRod
cutRod = { prices, length ->
	if(length == 0){
		new RevenueDetails(0,[])
	}
	else{
		def maxRevenueDetails = new RevenueDetails(Integer.MIN_VALUE,[])
		for(rodSize in 1..length){
			def revenueFromSecondHalf = cutRod(prices, length - rodSize)
			def potentialRevenue = new RevenueDetails(
				prices[rodSize] + revenueFromSecondHalf.revenue,
				revenueFromSecondHalf.splits + rodSize)
			if(potentialRevenue.revenue > maxRevenueDetails.revenue)
				maxRevenueDetails = potentialRevenue
		}
		maxRevenueDetails
	}
}.memoize()

timeIt desiredLength, {length -> cutRod(rodPrices, length)}
