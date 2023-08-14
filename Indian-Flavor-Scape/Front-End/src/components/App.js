import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import LogSign from "./SignupLogin/LogSign.js";
import Log from "./SignupLogin/Log.js";
import ChickenBiryaniPage from "./Main Dishes/ChickenBiryaniPage";
import { Home } from "./Home/Home.js";
import Dashboard from "./Dashboard/Dashboard.js";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import AdditiveDish from "./Additive Dishes/AdditiveDish";
import SideDish from "./Side Dishes/SideDish";
import Orders from "./Side Dishes/Orders";
import UpdateOrders from "./Update Order/UpdateOrders";
import { ContactUs } from "./ContactUs/ContactUs.js";
import { About } from "./About/About.js";


function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/Home" element={<Home />} />
          <Route path="/CustomerLogin" element={<LogSign active="first" />} />
          <Route path="/CustomerSignup" element={<LogSign active="second" />} />
          <Route path="/EmployeeLogin" element={<Log />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/ChickenBiryaniPage" element={<ChickenBiryaniPage />} />
          <Route path="/AdditiveDish" element={<AdditiveDish />} />
          <Route path="/SideDish" element={<SideDish />} />
          <Route path="/Orders" element={<Orders />} />
          <Route path="/UpdateOrders" element={<UpdateOrders />} />
          <Route path="/ContactUs" element={<ContactUs />} />
          <Route path="/About" element={<About />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
