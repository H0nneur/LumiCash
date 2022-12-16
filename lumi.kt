class Account (val name: String, val number: Int, private var pinCode: Int) {
    private var balance: Int = 10000
    
    fun showBalance(){
        println("You now have $balance on your account")
    }

    fun deposit(amount){
        balance += amount
        showBalance()
    }

    fun withdraw(amount){
        if(balance < amount){
            showBalance()
            println("You don't have enough money to withdraw $amount")
        }else{
            balance -= amount
            showBalance()
        }
    }

    fun verifyPinCode(code: Int): Boolean{
        return code == pinCode
    }
}

fun main(){

}