import "./card.scss" 
interface CardAccount{
    cashBalance: number;
    totalExpenses: number;
    totalCash: number

}
export function Card({cashBalance, totalExpenses, totalCash} : CardAccount){
    return(
       <div className="card">
        <img src="" alt="" />
        <h2>Account</h2>
        <p><b>Cash balance:</b> {cashBalance}</p>
        <p><b>Total expenses:</b> {totalExpenses}</p>
        <p><b>Total cash:</b> {totalCash}</p>
       </div>
    )
}