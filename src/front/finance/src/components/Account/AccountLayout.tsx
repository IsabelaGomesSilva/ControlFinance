import "./AccountLayout.scss"
import accountImage from '../../assets/Account.png';

interface Account{
    cashBalance: string;
    totalExpenses: string;
    totalCash: string;

}
export function Account({cashBalance, totalExpenses, totalCash} : Account){
    return(
        
        <div className="card">
            <div className="card-content">
                <h2>Total account</h2>
                <div className="card-rectangles">
                    <div className="rectangle-balance">
                        <h3>Balance</h3>
                        <p style={{ color: (cashBalance.includes("-"))? 'red' : 'green' }}>{cashBalance}</p>
                    </div>
                    <div className="rectangle">
                        <div className="pair">
                            <h3>Total cash</h3>
                            <p style={{ color: 'green' }}>{totalCash}</p>
                        </div>
                        <div className="pair">
                            <h3>Total expenses</h3>
                            <p style={{ color: 'red' }}>{totalExpenses}</p>
                        </div>
                    </div>
                </div>
            </div>
            <div className="card-side">
               
                <img src={accountImage} alt="Descrição da Imagem" />
            </div>
      </div>
    )
}