import React from "react";
import Navbar from "../Navbar/NavBar.js";
import './ContactUs.css';

export const ContactUs = () => {
  return (
    <div>
      <div className="absol">
        <div className="top-div"></div>
        <Navbar />
        <img className="img-home" src="./images/ContactUs.jpg" alt="Contact-Us" />
        <h2 className='text-center' col-lg-6> Got a problem Dont worry!!!</h2>
        <h2 className='text-center' col-lg-6> We are here to help you</h2>
        <h3 className='text-center' col-lg-6> Phone : +1 314 XXXXXXXX </h3>
        <h3 className='text-center' col-lg-6>Phone : +1 314 XXXXXXXXX </h3>
        <h3 className='text-center' col-lg-6>indiaflavorscape@gmail.com</h3>
      </div>
    </div>
  );
};

