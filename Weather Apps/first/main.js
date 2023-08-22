const apiKey = "09da1c26a3c809dd2d2049bbc64d0b8f";
const apiUrl = "https://api.openweathermap.org/data/2.5/weather?units=metric&q=";
const searchBox = document.querySelector(".search input");
const searchBtn = document.querySelector(".search button");
const weatherIcon = document .querySelector(".weather-icon");

$(document).ready(function () {

   searchBtn.addEventListener("click", ()=>{

        checkWeather(searchBox.value);

   });  
 });


 async function checkWeather(city){
    const response = await fetch(apiUrl + city +`&appid=${apiKey}`);
    
    if(response.status == 404){
        document.querySelector(".error").style.display ="block";
        document.querySelector(".weather").style.display ="none";
    }else{
    
        var data = await response.json();

        console.log(data);

        document.querySelector(".city").innerHTML = data.name;
        document.querySelector(".temp").innerHTML = Math.round(data.main.temp) + "°C";
        document.querySelector(".humidity").innerHTML = data.main.humidity + "%";
        document.querySelector(".wind").innerHTML = data.wind.speed + "km/h";

        if(data.weather[0].main == "Clouds"){
            weatherIcon.src ="https://cdn-icons-png.flaticon.com/512/252/252035.png";
        }
        else if(data.weather[0].main == "Clear"){
            weatherIcon.src ="https://cdn-icons-png.flaticon.com/512/831/831682.png";
        }
        else if(data.weather[0].main == "Rain"){
            weatherIcon.src ="https://cdn-icons-png.flaticon.com/512/4150/4150897.png";
        }
        else if(data.weather[0].main == "Drizzle"){
            weatherIcon.src ="https://cdn-icons-png.flaticon.com/512/4837/4837659.png";
        }
        else if(data.weather[0].main == "Mist"){
            weatherIcon.src ="https://cdn-icons-png.flaticon.com/512/1197/1197102.png";
        }

        document.querySelector(".weather").style.display = "block";
        document.querySelector(".error").style.display ="none";
    } 
} 
