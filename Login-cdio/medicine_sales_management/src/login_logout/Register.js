import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEye, faEyeSlash } from "@fortawesome/free-solid-svg-icons";
import { Link, useLocation, useNavigate } from "react-router-dom";
import React, { useState, useContext, useEffect } from "react";
import { toast } from "react-toastify";
import axios from "axios";

const Register = () => {
  const [hiddenPassword, setHiddenPassword] = useState(true);
  const [hiddenRePassword, setHiddenRePassword] = useState(true);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [rePassword, setRePassword] = useState("");
  const navigate = useNavigate();
  const notify = (message, type) => {
    const toastType = type === "success" ? toast.success : toast.error;
    return toastType(message);
  };
  // Set state for navigation register success
  useEffect(() => {
    // if (location.state?.toastMessage !== "") {
    //   notify(location.state?.toastMessage, "success");
    //   navigate(location.pathname, { replace: true, state: {} });
    // }
  }, []);

  const validationPassword = (oldPass, newPass) => {
    const passwordRegex = /^[a-zA-Z0-9]{8,}$/;
    // Use a regular expression to enforce password strength rules
    const isStrong = passwordRegex.test(password);
    !isStrong &&
      notify(
        "Mật khẩu ít nhất 6 ký tự và báo gồm chữ in hoa, chữ thường, và số!",
        "error"
      );
    if (oldPass !== newPass) {
      notify("Mật khẩu không trùng khớp, vui lòng nhập lại!", "error");
      return false;
    }
    return true;
  };

  // handle call api register
  const handleSubmit = async (e) => {
    e.preventDefault();
    if (validationPassword(password, rePassword)) {
      // fetch register
      try {
        const registerResponse = await axios.post(
          "http://localhost:8080/api/auth/register",
          {
            username: email,
            password: password,
          },
          {
            headers: {
              "Content-Type": "application/json",
            },
          }
        );
        console.log(registerResponse);
        // check output and display error if has error
        if (registerResponse?.status === 200) {
          navigate("/login", {
            state: { toastMessage: "Đăng Ký Thành Công!" },
          });
        } else {
          if (registerResponse?.response?.status === 409) {
            notify(
              "Email đã tồn tại, vui lòng đăng ký bằng email khác!",
              "error"
            );
          } else {
            console.log(registerResponse?.response);
            notify("Đăng ký thất bại!", "error");
          }
        }
      } catch (e) {
        if (e?.response?.status === 406) {
          navigate("/login", {
            state: { toastMessage: "Đăng Ký Thành Công!" },
          });
        } else {
          notify("Đăng ký thất bại!", "error");
        }
      }
    }
  };

  return (
    <div className="mx-auto grid grid-cols-12">
      <div className="col-span-12  lg:col-span-7 ">
        <form
          action=""
          onSubmit={(e) => {
            handleSubmit(e);
          }}
          className="pb-12 w-[90%] mx-auto pl-5 pr-5"
        >
          <h1 className="pt-12 text-4xl text-primaryColor font-bold text-center">
            Đăng Ký
          </h1>
          <div className="w-[400px] h-[200px] mb-9 overflow-hidden mx-auto">
            <img
              className="w-full h-full object-cover"
              src={require("../assets/images/logoTransparent.png")}
              alt=""
            />
          </div>
          <div className="block md:flex md:justify-between">
            <div className="w-full md:w-[45%] ">
              <div className="w-full mb-4">
                <label
                  className="block text-[18px] font-bold text-textBoldColor mb-2"
                  htmlFor="inputEmail"
                >
                  Email
                </label>
                <input
                  className="block w-full pl-4 pr-10 py-3 shadow rounded-xl outline-none"
                  id="inputEmail"
                  type="email"
                  placeholder="email@gmail.com"
                  pattern=".+@gmail\.com"
                  title="Vui lòng nhập đúng địa chỉ email với đuôi @gmail.com"
                  required
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
              </div>
              <div className="relative w-full mb-4">
                <label
                  className="block text-[18px] font-bold text-textBoldColor mb-2"
                  htmlFor="inputPassword"
                >
                  Mật Khẩu
                </label>
                <div className="w-full">
                  <input
                    className="block w-full pl-4 pr-10 py-3 shadow rounded-xl outline-none"
                    id="inputPassword"
                    type={hiddenPassword ? "password" : "text"}
                    placeholder="Mật khẩu"
                    required
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    max={15}
                  />

                  {hiddenPassword ? (
                    <FontAwesomeIcon
                      onClick={() => setHiddenPassword(!hiddenPassword)}
                      icon={faEyeSlash}
                      className="absolute bottom-4 right-4 hover:cursor-pointer"
                    />
                  ) : (
                    <FontAwesomeIcon
                      onClick={() => setHiddenPassword(!hiddenPassword)}
                      icon={faEye}
                      className="absolute bottom-4 right-4 hover:cursor-pointer"
                    />
                  )}
                </div>
              </div>
              <div className="relative w-full mb-4">
                <label
                  className="block text-[18px] font-bold text-textBoldColor mb-2"
                  htmlFor="inputRePassword"
                >
                  Nhập Lại Mật Khẩu
                </label>
                <div className="w-full">
                  <input
                    className="block w-full pl-4 pr-10 py-3 shadow rounded-xl outline-none"
                    id="inputRePassword"
                    type={hiddenRePassword ? "password" : "text"}
                    placeholder="Nhập lại mật khẩu"
                    required
                    value={rePassword}
                    onChange={(e) => setRePassword(e.target.value)}
                    max={15}
                  />

                  {hiddenRePassword ? (
                    <FontAwesomeIcon
                      onClick={() => setHiddenRePassword(!hiddenRePassword)}
                      icon={faEyeSlash}
                      className="absolute bottom-4 right-4 hover:cursor-pointer"
                    />
                  ) : (
                    <FontAwesomeIcon
                      onClick={() => setHiddenRePassword(!hiddenRePassword)}
                      icon={faEye}
                      className="absolute bottom-4 right-4 hover:cursor-pointer"
                    />
                  )}
                </div>
              </div>
            </div>
          </div>
          <div className=" mt-5">
            <button
              className=" w-full px-4 py-3 text-xl font-bold text-white bg-primaryColor rounded-2xl shadow-primaryColor hover:shadow-lg hover:opacity-90"
              type="submit"
            >
              Đăng Ký
            </button>
          </div>
          <div className=" mt-5 text-center">
            <p className="">
              Đã Có Tài Khoản!{" "}
              <Link to="/login" className=" text-primaryColor">
                Đăng Nhập
              </Link>
            </p>
          </div>
        </form>
      </div>
      <div className="h-full hidden md:block lg:block  lg:col-span-5">
        <img
          className="w-full h-full object-cover"
          src="https://img.freepik.com/fotos-premium/diseno-hogar-moderno-fondo-jardin-cielo_741910-5826.jpg?w=2000"
          alt="ảnh nhà"
        />
      </div>
    </div>
  );
};

export default Register;
