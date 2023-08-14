import Cookies from "universal-cookie";
import { API_BASE_URL } from "../../constants";
import {
  customer_signIn,
  customer_signUp,
  employee_signIn,
  getMainDishes,
  getAdditives,
  getSides,
  placeOrder,
  updateOrderStatus,
  getAllOrders,
} from "./APIUrl.js";
import { customer } from "../Functions/CommonScripts.js";

export const cookieslog = new Cookies();
export const cook_log = cookieslog.get("login");
export const respSuccess = "10200";
export const respSuccess_2 = "10200";
export const respSuccess_3 = "10201";
export const internalError = "10404";
export const internalError_2 = "10409";
export const userPassError = "Please check the Username/Password";
export const userExist = "User Already Exists. Please Signup Again";
export const successMessage = "Successful Credentials";
export const validEmail = "Valid Email";
export const validPassword = "Valid Password";
export const validUsername = "Valid Username";
export const invalidCredentials = "Invalid Credentials";

export function loginForm(
  player,
  setMessageInvalid,
  setCookie,
  userName,
  empty
) {
  fetch(API_BASE_URL + customer_signIn, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(player),
  })
    .then((response) => response.json())
    .then((responseJson) => {
      console.log(responseJson);
      if (responseJson.statusCode === respSuccess) {
        setMessageInvalid(successMessage);
        setCookie("user", userName, { path: "/" });
        setCookie("customer", responseJson.customerId, { path: "/" });
        cookieslog.remove("login");
        empty();
        window.location.href = "/Home";
      } else if (responseJson.statusCode === internalError) {
        setMessageInvalid(userPassError);
        empty();
      }
    })
    .catch();
}

export function employeeLoginForm(
  player,
  setMessageInvalid,
  setCookie,
  userName,
  empty
) {
  fetch(API_BASE_URL + employee_signIn, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(player),
  })
    .then((response) => response.json())
    .then((responseJson) => {
      console.log(responseJson);
      if (responseJson.statusCode === respSuccess) {
        setMessageInvalid(successMessage);
        setCookie("user", userName, { path: "/" });
        setCookie("customer", "admin", { path: "/" });
        cookieslog.remove("login");
        empty();
        window.location.href = "/Home";
      } else if (responseJson.statusCode === internalError) {
        setMessageInvalid(userPassError);
        empty();
      }
    })
    .catch();
}

export function signUpForm(
  player,
  setMessageInvalid,
  setCookie,
  empty,
  navigate
) {
  fetch(API_BASE_URL + customer_signUp, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(player),
  })
    .then((response) => response.json())
    .then((responseJson) => {
      console.log(responseJson);
      console.log(responseJson);
      if (responseJson.statusCode === respSuccess_3) {
        setMessageInvalid(successMessage);
        setCookie("login", "Success", { path: "/" });
        empty();
        navigate("/CustomerLogin");
      } else if (responseJson.statusCode === internalError_2) {
        setMessageInvalid(userExist);
        empty();
      }
    })
    .catch();
}

export function getMainDishesFood(setDish) {
  fetch(API_BASE_URL + getMainDishes, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((responseJson) => {
      setDish(responseJson["mainDishes"]);
    })
    .catch();
}

export function getAdditiveDishesFood(id, setDish) {
  const add = { id: id };
  fetch(API_BASE_URL + getAdditives, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(add),
  })
    .then((response) => response.json())
    .then((responseJson) => {
      setDish(responseJson["additives"]);
    })
    .catch();
}

export function getSideDishesFood(id, setDish) {
  const add = { id: id };
  fetch(API_BASE_URL + getSides, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(add),
  })
    .then((response) => response.json())
    .then((responseJson) => {
      setDish(responseJson["sides"]);
    })
    .catch();
}

export function placeOrders(id, idAdd, idSide) {
  const order = {
    customerId: customer,
    orderStatus: "ordered",
    mainDishId: id,
    additiveId: idAdd,
    sideId: idSide,
  };
  fetch(API_BASE_URL + placeOrder, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(order),
  });
}

export function getOrders(setOrders) {
  fetch(API_BASE_URL + getAllOrders, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((responseJson) => {
      setOrders(responseJson["orders"]);
    })
    .catch();
}

export function updateOrder(id, status) {
  const order = {
    orderStatus: id,
    orderId: status,
  };
  console.log(order);
  fetch(API_BASE_URL + updateOrderStatus, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(order),
  });
}
