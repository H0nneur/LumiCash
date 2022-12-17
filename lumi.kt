class Account (val name: String, val number: Int, private var pinCode: Int) {
    private var balance: Int = 10000
    
    fun showBalance(){
        println("You now have $balance on your account")
    }

    fun deposit(amount: Int){
        balance += amount
        showBalance()
    }

    fun withdraw(amount: Int){
        if(balance < amount){
            showBalance()
            println("You don't have enough money to withdraw $amount")
        }else{
            balance -= amount
            showBalance()
        }
    }

    fun transferTo(account: Account, amount: Int){
        val bal = balance
        withdraw(amount)
        if(bal >= amount){
            account.balance += amount
        }
    }

    fun verifyPinCode(code: Int): Boolean{
        return code == pinCode
    }
}

val myAccount = Account("Honneur", 61000001, 1234)
val allysAccount = Account("Ally", 61100047, 0000)

fun showMenu(){
    println("Lumicash - pls choose:\n" +
            "1.Transfer\n" +
            "2.Cash out\n" +
            "3.Buy airtime\n" +
            "4.Pay bills\n" +
            "5.Pay Merchant\n" +
            "6.Banking service\n" +
            "7.OBR\n" +
            "8.Mairie\n" +
            "9.Fertiliser\n" +
            "10.Utilities")
}

fun getInputChoice(choices: Int): Int?{
    val input = readln()
    val choice = input.toIntOrNull()
    if(choice == null || !(choice in 1..choices)){
        println("Your input is invalid. Choose a number from 1 to $choices.\n\n")
        return null
    }else{
        return choice 
    }
}

fun getInputPhoneNumber(): Int?{
    println("Enter Phone number(put 61100047 for now):\n" +
            "0. Return\n\n")
    val input = readln()
    val phoneNumber = input.toIntOrNull()
    if(phoneNumber == null || !(phoneNumber in 61000000..69999999) || phoneNumber != 0){
        println("The given phone number is invalid.\n\n")
        return null
    }else{
        return phoneNumber
    }
}

fun getInputAmount(): Int?{
    println("Enter the amount:\n" + 
            "0. Return\n\n")
    val input = readln()
    val amount = input.toIntOrNull()
    if(amount == null || amount < 0){
        println("The given amount is invalid.\n\n")
        return null
    }else{
        return amount
    }
}

fun getPincode(message: String){
    //TO DO!!!
}

fun proceedToContentTransfer(amount: Int?){
    when(amount){
        null -> getInputAmount()
        0 -> proceedToTransfer()
        else -> {
            println("Enter the transfer content:" +
                    "0. Return\n\n")
            val input = readln()
            if(input == "0"){
                getInputAmount()
            }else{
                getPincode(input)
            }
        }
    }
}

fun proceedToTransfer(){
    val phoneNumber = getInputPhoneNumber()
    when(phoneNumber){
        0 -> startLumicash()
        61000001 -> {println("You can't transfer money to yourself.\n" +
                             "The phone number must be different from yours.\n\n")
                     proceedToTransfer()}
        61100047 -> getInputAmount()
        else -> {println("Unkown phone number. Try an other one.\n\n")
                 proceedToTransfer()}
    }
}

fun chooseFromMenu(choice: Int){
    when(choice){
        1 -> proceedToTransfer()
        in 2..10 -> {println("This option is still being build.\n\n")
                     startLumicash()}
    }
}

fun startLumicash(){
    showMenu()
    val choice = getInputChoice(10)
    if(choice == null){
        startLumicash()
    }else{
        chooseFromMenu(choice)
    }
}

fun main(){

}