import { useState, useEffect } from 'react';

import './CardCarousel.scss';
import { CashData } from '../../../interface/CashData';
import { CardCash } from './Card';

interface CardCarouselProps {
  cardsData: CashData[];
}

export function CardCarousel({ cardsData  }: CardCarouselProps ) {
  const [currentIndex, setCurrentIndex] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentIndex((prevIndex) => (prevIndex + 1) % cardsData.length);
    }, 5000);

    return () => clearInterval(interval);
  }, [cardsData.length]);

  const handleNext = () => {
    setCurrentIndex((prevIndex) => (prevIndex + 1) % cardsData.length);
  };

  const handlePrev = () => {
    setCurrentIndex((prevIndex) => (prevIndex - 1 + cardsData.length) % cardsData.length);
  };

  return (
    <div className="card-carousel">
          <div className="card-container" style={{ transform: `translateX(-${currentIndex * 100}%)` }}>
            {cardsData?.map(cashData => 
              <CardCash key={cashData.id}
              additionDate={cashData.additionDate}
              idCategory={cashData.idCategory}
              isEnabled={cashData.isEnabled}
              updateDate={cashData.updateDate}
              value={cashData.value}
              description={cashData.description}
               idAccount={''} id={''}              />
            )} 
          </div>
          <button onClick={handlePrev}>&lt;</button>
          <button onClick={handleNext}>&gt;</button>
        </div>
  );
}