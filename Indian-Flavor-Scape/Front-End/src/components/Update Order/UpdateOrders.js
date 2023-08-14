import React, { useState, useEffect } from "react";
import { getOrders } from "../Functions/APIFunctions.js";
import "../Side Dishes/Orders.css";
import { updateOrder } from "../Functions/APIFunctions.js";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Navbar from "../Navbar/NavBar.js";

function UpdateOrders() {
  const [order, setOrder] = useState({});
  const [sub, setSub] = useState();

  useEffect((e) => {
    getOrders(setOrder);
  }, []);

  const onValueChange = () => {
    const subStr = sub.split(",");
    updateOrder(subStr[0], subStr[1]);
    window.location.reload(false);
  };

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
            <th>updateStatus</th>
            <th>submitButton</th>
          </tr>
          {Object.keys(order).map((key, i) => (
            <React.Fragment key={i}>
              <tr>
                <td>{order[key]["orderId"]}</td>
                <td>{order[key]["orderItem"]}</td>
                <td>{order[key]["orderStatus"]}</td>
                <td>{order[key]["orderTime"]}</td>
                <td>
                  <Form.Check
                    inline
                    label="INPROGRESS"
                    name={"group1" + order[key]["orderId"]}
                    type="radio"
                    id={"group1" + order[key]["orderId"]}
                    onChange={(e) =>
                      setSub("inprogress," + order[key]["orderId"])
                    }
                  />
                  <Form.Check
                    inline
                    label="DELIVERED"
                    name={"group1" + order[key]["orderId"]}
                    type="radio"
                    id={"group2" + order[key]["orderId"]}
                    onChange={(e) =>
                      setSub("delivered," + order[key]["orderId"])
                    }
                  />
                  <Form.Check
                    inline
                    label="CANCELLED"
                    name={"group1" + order[key]["orderId"]}
                    type="radio"
                    id={"group3" + order[key]["orderId"]}
                    onChange={(e) =>
                      setSub("cancelled," + order[key]["orderId"])
                    }
                  />
                </td>
                <td>
                  <Button
                    variant="primary"
                    type="submit"
                    onClick={onValueChange}
                  >
                    Submit
                  </Button>
                </td>
              </tr>
            </React.Fragment>
          ))}
        </table>
      </div>
    </>
  );
}

export default UpdateOrders;
