Feature: product data tables practice

@listOfMap
  Scenario: verify each product price
    # practice List<Map<String, String>>

    Given user is on the Homepage
    Then user should be able to see expected prices in the following prices
      | Category | Product           | expectedPrice |
      | Phones   | Samsung galaxy s6 | 360           |
      | Phones   | Nokia lumia 1520  | 820           |
      | Phones   | Nexus 6           | 650           |
      | Laptops  | Sony vaio i5      | 790           |
      | Laptops  | Sony vaio i7      | 790           |
      | Laptops  | MacBook air       | 700           |
      | Monitors | Apple monitor 24  | 400           |
      | Monitors | ASUS Full HD      | 230           |


    # List element = 1 (Map)
             #key=value       key-value                key-value
       #{Category=Phones, Product=Samsung galaxy4, expectedPrice=360}
    # List element = 2 (Map)
       #{Category=Phones, Product=Nokia lumia 1520, expectedPrice=820}
    # List element = 3 (Map)
       #{Category=Phones, Product=Nexus 6, expectedPrice=650}


    #We have List of Map, with 8 elements
    #Each element is Map (key=value)
    #Each Map has 3 elements (String)

    #first row is always a key of our Map


  @ListOfList

  #practice List of List <List<String>>
  Scenario: verify each product price ListOfList
    Given user is on the Homepage
    Then user should be able to see expected prices in the following products with ListOfLists

      | Phones   | Samsung galaxy s6 | 360           |
      | Phones   | Nokia lumia 1520  | 820           |
      | Phones   | Nexus 6           | 650           |
      | Laptops  | Sony vaio i5      | 790           |
      | Laptops  | Sony vaio i7      | 790           |
      | Laptops  | MacBook air       | 700           |
      | Monitors | Apple monitor 24  | 400           |
      | Monitors | ASUS Full HD      | 230           |

      #  List Element 1 (List<String>): [Phones, Samsung galaxy s6, 360]
#  List Element 2 (List<String>): [Phones, Nokia lumia 1520, 820]
#  List Element 3 (List<String>): [Phones, Nexus 6, 650]
#  List Element 4 (List<String>): [Laptops, Sony vaio i5, 790]
#  List Element 5 (List<String>): [Laptops, Sony vaio i7, 790]
#  List Element 6 (List<String>): [Laptops, MacBook air, 700]
#  List Element 7 (List<String>): [Monitors, Apple monitor 24, 400]
#  List Element 8 (List<String>): [Monitors, ASUS Full HD, 230


  @mapList
  #practice Map< String,List<String> >

  Scenario: verify students on discord
    Then user should be able to see the following names in their groups
      | Group 1 | Nadir  | Feyruz | Shakir  |
      | Group 2 | Yuliia | Diana  | Nazarii |

    # List Element 1: Group2 = [Yuliia, Diana, Nazarii]
    #List Element 2: Group1 = [Nadir, Feyruz, Shakir]
