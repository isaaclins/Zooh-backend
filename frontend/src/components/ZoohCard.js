import 'bootstrap/dist/css/bootstrap.min.css' //Import Bootstrap CSS
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

function ZoohCard(props) {
  return (
    <Card style={{ width: '18rem', margin: '20px'}}>
      <Card.Img variant="top" src={props.image} />
      <Card.Body>
        <Card.Title>Card Title</Card.Title>
        <Card.Text>
          {props.text}
        </Card.Text>
        <Button variant="primary">Go somewhere</Button >
      </Card.Body>
    </Card>
  );
}

export default ZoohCard;