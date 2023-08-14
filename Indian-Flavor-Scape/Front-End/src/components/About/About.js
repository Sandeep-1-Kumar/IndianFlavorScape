import React from "react";
import Navbar from "../Navbar/NavBar.js";
import "./About.css"; 

export const About = () => {
  return (
    <div>
      <div className="absol">
        <Navbar />
        <div className="about-content">
          <h1>Indian Flavor Scape</h1>
          <p>
            A culinary paradise where traditional Indian flavors harmonize with modern digital convenience. 
            At Indian Flavor Scape, we are on a mission to revolutionize the way you experience Indian cuisine. 
            Our restaurant offers a unique and innovative web application that brings the entire ordering process to your fingertips.
          </p>
          <p>
            Gone are the days of traditional paper menus and long waiting times. 
            With our cutting-edge web application, you can embark on a delightful gastronomic journey right from the comfort of your own device. 
            From the moment you step into our virtual space, you'll be enchanted by a seamless and user-friendly interface that caters to all your culinary desires.
          </p>
          <p>
            At Indian Flavor Scape, we take pride in marrying the timeless appeal of traditional Indian cuisine with the technological innovations of the digital age. 
            Join us on this culinary adventure, where every visit promises to be a delectable exploration of flavors, all at your fingertips. 
            Experience the future of dining with Indian Flavor Scape, where the magic of India's culinary heritage meets the wonders of modern technology.
          </p>
        </div>
      </div>
    </div>
  );
};
