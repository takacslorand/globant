package com.globant.got.client.model;

import lombok.Data;

@Data
public class Book {


    String url;             //The hypermedia URL of this resource
    String name;            //The name of this book
    String isbn;            //The International Standard Book Number (ISBN-13) that uniquely identifies this book.
    String[] authors;       //An array of names of the authors that wrote this book.
    Integer numberOfPages;  //The number of pages in this book.
    String publiser;        //The company that published this book.
    String country;         //The country that this book was published in
    String mediaType;       //The type of media this book was released in.
    String released;        //The date (ISO 8601) when this book was released.
    String[] characters;    //An array of Character resource URLs that has been in this book.
    String[] povCharacters; //An array of Character resource URLs that has had a POV-chapter in this book.
}
