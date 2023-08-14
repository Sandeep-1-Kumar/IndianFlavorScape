import React from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import { placeOrders } from "../Functions/APIFunctions.js";
import Button from "react-bootstrap/Button";
import Navbar from "../Navbar/NavBar.js";

function SideDish() {
  const navigate = useNavigate();
  const [searchparams] = useSearchParams();

  const id = searchparams.get("mainDishId");
  const idAdd = searchparams.get("additiveId");
  const idSide = searchparams.get("sideId");

  const getOrder = () => {
    placeOrders(id, idAdd, idSide);
  };

  return (
    <>
      <div className="absol" style={{ position: "sticky" }}>
        <div className="top-div"></div>
        <Navbar />
      </div>
      <div style={{ textAlign: "center", marginTop: "50vh" }}>
        <Button
          variant="primary"
          type="button"
          size="lg"
          onClick={() => {
            getOrder();
            navigate("/Orders");
          }}
        >
          ORDER NOW
        </Button>
      </div>
    </>
  );
}

export default SideDish;
