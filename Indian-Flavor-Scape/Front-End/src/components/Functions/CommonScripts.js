import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import Cookies from "universal-cookie";

export const cookieslog = new Cookies();
export const email = cookieslog.get("user");
export const customer = cookieslog.get("customer");
export function CommonScripts() {
  return <div></div>;
}
