import './App.scss'
import { Account } from './components/Account/AccountLayout';
import { useAccountData, useCashData, useExpensesData } from './hooks/ServiceAPI';
import { CardCarousel } from './components/Cash/Card/CardCarousel';

function App() {
  const {data }= useAccountData();
  const {data: dataCash} = useCashData();
  const dataExpenses = useExpensesData().data;
  

  return (
    <main>
      <header className='header-container'>
        <div className='logo-container' >
          <img src="./logo1.png" alt="Finance Control Logo" className='logo' />
          <div className='logo-txt'>
            <span className='logo-txt-bold'>Finance</span>
            <span className='logo-txt-regular'>control</span>
          </div>
        </div>
        <nav className="menu-options">
          <a href="#account-section">Account</a>
          <a href="#cash-section">Cash</a>
          <a href="#expenses-section">Expenses</a>
        </nav>
        <div className='img-header'>
          <img src="./img-header.png"  className='image-header'/>
        </div>
        
      </header>
      
      <div className="content-container">
        <div className="heading-container">
          <h2>Master your money,</h2>
          <h2> make smarter decisions.</h2>
        </div>
        <div className="bubble target">
        🎯
        </div>
        <div className="bubble chart">
        📊
        </div>
        <div className="bubble bag">
        💰
        </div>
        <div className="bubble money">
        💸
        </div>
      </div>
      <section id="account-section">
       <div className="container">
        <div className="card-grid">
        {dataCash ? ( data?.map(accountData => 
            <Account key={accountData.id}
              cashBalance={accountData.cashBalance}
              totalExpenses={accountData.totalExpenses}
              totalCash={accountData.totalCash}
            />)) : (
            <div>Loading cards...</div>
         )}
        </div>
       </div>
      </section>

      <section id="cash-section">
        <div className="container">
          <div className="card-grid">
            {dataCash ? ( <CardCarousel cardsData={dataCash} />
            ) : (
            <div>Loading cards...</div>
             )}
          </div>
        </div>
      </section>

      <section id="expenses-section">
        <div className="container">
          <div className="card-grid">
            {dataExpenses ? ( dataExpenses?.map(cashData => 
              <Account key={cashData.id}
                cashBalance={""}
                totalExpenses={''}
                totalCash={''}
              />)
            ) : (
            <div>Loading cards...</div>
             )}
          </div>
        </div>
      </section>
      <footer id="main-footer">
        <img src="./logo1.png" alt="Finance Control Logo" className='logo' />
        
        <div className="footer-name">
          <h5>Desenvolvido por Isa</h5>
        </div> 
        <div className='img-header'>
          <img src="./img-header.png"  className='image-header'/>
        </div> 
      </footer>
    </main>
  )
}

export default App