import './App.scss'
import { Card } from './components/card/card';
import { AccountData } from './interface/AccountData';

function App() {
  const data: AccountData[] = [];
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
          <a href="">Account</a>
          <a href="">Cash</a>
          <a href="">Expenses</a>
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
          {data.map(accountData => 
            <Card 
              cashBalance={accountData.cashBalance}
              totalExpenses={accountData.totalExpenses}
              totalCash={accountData.totalCash}
            />
          )}
        </div>
       </div>
      </section>

      <section id="cash-section">
      <h1> a</h1>
      </section>

      <section id="expenses-section">
      <h1> a</h1>
      </section>
    </main>
  )
}

export default App