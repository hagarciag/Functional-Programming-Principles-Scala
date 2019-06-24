package week3

//It is possible to import from either a package or an object.

//Imports only Rational: named import
import week2.Rational

//Imports both Rational and Hello: : named import
//import week2.{Rational, Hello}

//Imports everithing in package 2: wildcard import
//import Week2._

object Lecture3_2_Classes_Organization {
  print("")
  //Two way to invoke classes
  new week2.Rational(2,3)                         //> res0: week2.Rational = 2/3
  new Rational(2,3)                               //> res1: week2.Rational = 2/3
  
  //Later in this file Exc and Nothing datatype are discused
  def error(msg: String) = throw new Error(msg)   //> error: (msg: String)Nothing
	error("test")                             //> java.lang.Error: test
                                                  //| 	at week3.Lecture3_2_Classes_Organization$.error$1(week3.Lecture3_2_Class
                                                  //| es_Organization.scala:21)
                                                  //| 	at week3.Lecture3_2_Classes_Organization$.$anonfun$main$1(week3.Lecture3
                                                  //| _2_Classes_Organization.scala:22)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$anonfun$$ex
                                                  //| ecute$1(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:76)
                                                  //| 	at week3.Lecture3_2_Classes_Organization$.main(week3.Lecture3_2_Classes_
                                                  //| Organization.scala:14)
                                                  //| 	at week3.Lecture3_2_Classes_Organization.main(week3.Lecture3_2_Classes_O
                                                  //| rganization.scala)
	
	//Nulls are discussed later in this file
	val x = null
	val y: String = null
	//val z: Int = null
}

//Some entities are automatically imported in any Scala program. These are:
//- All memebers of package scala
//- All memebers of package java.lang
//- All members of the singleton object scala.Predef.

//Here are the fully qualified names of some types and functions which you have seen so far:
//Int					scala.Int
//Bolean			scala.Boolean
//Object			java lang Object
//require			scala.Predef.require
//assert			scala.Predef.assert


//Traits
//Scala and Java classes can have only one superclass: they are single inheritance languages
//If a class has several natual supertypes to which it conforms of from
// which it wants to inherit code. Here, you could use traits

//A trait is declared like an bastract class, just with trait instead of abstract class

trait Planar{
	def height: Int
	def width: Int
	def surface = height*width
}

//Classes, object and traits can inherit from at most one class but arbitrary many traits
//Example:
//class Square extends Shape with Planar with Movable

//Traits resemble interfaces in Java, but are more poweful because they can contain fields and concrete metrhods.
//On the other hand, traits cannot have (value) parameters, only classes can.


//Top Types
//At the top of the type hierarchy we find:
//Any				The base type of all types
//					Methods: '==', '!=', 'equals', 'hashCode', 'toString'

//AnyRef		The base type of all reference types; Alias of 'java.lang.Object'

//AnyVal		The base type of all primitive types


//The Nothing Type: it's a the bottom of Scala' type hierarchy. It's a subtype of every other type.
//There is no value of type Nothing. It is useful for two things:
//- To ignal abnormal termination
//- As an element type of empty collections

//Exceptions
//Scala's exception handling is similar to Java's.
//throw Exc
//aborts evaluation with the exception Exc.
//The type of this expression is Nothing


//Null is written in scala as in Java. It's a value of every reference type scala.AnyRef.
//Every reference class type also has null as a value
//The type of null is Null.
//Null is a subtype of every class that inherits from Object; it is incompatible with subtypes of AnyVal.