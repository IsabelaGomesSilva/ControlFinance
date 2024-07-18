import "./Card.scss"
import { CashData } from "../../../interface/CashData";

const formatDate = (date: string | Date) => {
    if (!date) return "N/A"; // Retorna "N/A" se a data não estiver disponível
    const dateObj = typeof date === "string" ? new Date(date) : date;
    return dateObj.toLocaleDateString();
  };
export function CardCash(
    {   additionDate,
        idCategory,
        isEnabled,
        updateDate,
        value,
        description
    } : CashData
){
    return(
        
        <div className="card-account" >
        <div className="card-content">
          <h2>Account Details</h2>
          <div className="card-rectangles">
            <div className="rectangle">
              <h3>Total Cash</h3>
              <p className="value" style={{ color: 'green' }}>{value}</p>
            </div>
            <div className="rectangle">
              <h3>Category</h3>
              <p>{idCategory}</p>
            </div>
            <div className="rectangle">
              <h3>Description</h3>
              <p>{description}</p>
            </div>
            <div className="rectangle">
              <h3>Enabled</h3>
              <p>{isEnabled ? "Yes" : "No"}</p>
            </div>
            <div className="rectangle">
              <h3>Addition Date</h3>
              <p>{formatDate( additionDate)}</p>
            </div>
            <div className="rectangle">
              <h3>Update Date</h3>
              <p>{formatDate(updateDate)}</p>
            </div>
          </div>
        </div>
      </div>
    )
}