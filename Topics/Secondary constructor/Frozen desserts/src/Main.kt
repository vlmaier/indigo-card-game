class IceCreamOrder {
    val price: Int

    constructor(popsicles: Int) {
        price = 7 * popsicles
    }

    constructor(scoops: Int, toppings: Int) {
        price = 5 * scoops + 2 * toppings
    }
}