/* eslint-disable no-mixed-operators */
import axios from 'axios';
import { useCallback, useEffect, useState } from 'react';
import { CounterType, TimeDisplayValuesType } from './types';
import { AppStyled, CounterStyled, ContainerStyled, WrapperStyled, DateStyled, ImageStyled } from './styles';
import React from 'react';

const App = () => {
  const basePath = 'http://localhost:8080/api';
  const [ pageTitle, setPageTitle ] = useState('');
  const [ nextYear, setNextYear ] = useState(new Date().getFullYear() + 1);
  const [ targetDate, setTargetDate ] = useState(new Date(`Jan 1, ${nextYear} 00:00:00`).getTime());

  // eslint-disable-next-line
  const generateTimeDisplay = useCallback((): TimeDisplayValuesType => {
    const rightJustNow = new Date().getTime();
    const runway = targetDate - rightJustNow;
    const stateObj = {
      days: Math.floor(runway / (1000 * 60 * 60 * 24)),
      hours: Math.floor((runway % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)),
      minutes: Math.floor((runway % (1000 * 60 * 60)) / (1000 * 60)),
      seconds: Math.floor((runway % (1000 * 60)) / 1000)
    };
    return stateObj;
  }, [targetDate]);

  const [timeDisplay, setTimeDisplay] = useState<TimeDisplayValuesType>(
    generateTimeDisplay
  );

  useEffect(() => {
    setInterval(() => setTimeDisplay(generateTimeDisplay), 1600);
  }, [generateTimeDisplay]);

  useEffect(() => {
    axios.get(basePath+'/welcome')
    .then(function (response) {
      if (response.data && response.data.length) {
      console.log('response :>> ', response);
      const { date, title } = response.data[0];
      setPageTitle(title);
      setTargetDate(date);
      console.log('date :>> ', date);
      console.log('date :>> ', typeof date);
      setNextYear(new Date(date).getFullYear());
      }
    })
    .catch(function (error) {
      console.log('Error:', error);
    })
  }, []);

  const Counter = ({ displayValue, label }: CounterType) => (
    <CounterStyled>
      <h2>{label}</h2>
      {displayValue}
    </CounterStyled>
  );

  const SpringAltText = "Spring logo";
  const SpringAnimated = <img src="/spring.png" alt={SpringAltText} height={30} width={30}/>;

  return (
    <div className="App">
      <AppStyled>
          <ContainerStyled>
            <DateStyled>
              <div><>{SpringAnimated} {pageTitle} {SpringAnimated}</></div>
            </DateStyled>
            <WrapperStyled>
              <Counter displayValue={timeDisplay.days} label={"Days"} />
              <Counter displayValue={timeDisplay.hours} label={"Hours"} />
              <Counter displayValue={timeDisplay.minutes} label={"Minutes"} />
              <Counter displayValue={timeDisplay.seconds} label={"Seconds"} />
            </WrapperStyled>
        </ContainerStyled>
      </AppStyled>
    </div>
  );
}

export default App;
