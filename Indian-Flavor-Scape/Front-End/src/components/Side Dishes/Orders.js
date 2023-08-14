import React, { useState, useEffect } from "react";
import { getOrders } from "../Functions/APIFunctions.js";
import { customer } from "../Functions/CommonScripts.js";
import "./Orders.css";
import Navbar from "../Navbar/NavBar.js";

function Orders() {
  const [order, setOrder] = useState({});

  useEffect(() => {
    getOrders(setOrder);
  }, []);

  return (
    <>
      <div className="absol" style={{ position: "sticky" }}>
        <div className="top-div"></div>
        <Navbar />
      </div>
      <div>
        <h4>Your Orders</h4>
        <table style={{ width: "100%" }}>
          <tr>
            <th>orderId</th>
            <th>orderItem</th>
            <th>orderStatus</th>
            <th>orderTime</th>
          </tr>
          {Object.keys(order).map(
            (key, i) =>
              order[key]["customerId"].toString() === customer && (
                <React.Fragment key={i}>
                  <tr>
                    <td>{order[key]["orderId"]}</td>
                    <td>{order[key]["orderItem"]}</td>
                    <td>{order[key]["orderStatus"]}</td>
                    <td>{order[key]["orderTime"]}</td>
                  </tr>
                </React.Fragment>
              )
          )}
        </table>
      </div>
    </>
  );
}

export default Orders;
