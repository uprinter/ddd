# DDD Building Blocks
Based on the book by Vladik Khononov "[Learning Domain-Driven Design: Aligning Software Architecture and Business Strategy](https://www.amazon.de/-/en/Vladik-Khononov/dp/1098100131/)".

![Learning Domain-Driven Design: Aligning Software Architecture and Business Strategy](https://m.media-amazon.com/images/I/41KQXS5X-xL._SX379_BO1,204,203,200_.jpg)

## Implementing Simple Business Logic
### Transaction Script
### Active Record

## Tackling Complex Business Logic

### Domain Model
#### Value object
- A value object is an object that can be identified by the composition of its values
- Value objects are implemented as immutable objects
- Since the equality of value objects is based on their values rather than on an id field or reference, it’s important to override and properly implement the equality checks
```
public class Color
{
    public readonly byte Red;
    public readonly byte Green;
    public readonly byte Blue;
    
    public Color(byte r, byte g, byte b)
    {
        this.Red = r;
        this.Green = g;
        this.Blue = b;
    }
    
    public Color MixWith(Color other)
    {
        return new Color(
            r: (byte) Math.Min(this.Red + other.Red, 255),
            g: (byte) Math.Min(this.Green + other.Green, 255),
            b: (byte) Math.Min(this.Blue + other.Blue, 255)
        );
    }
}
```

#### Entities
- An entity is the opposite of a value object
- It requires an explicit identification field to distinguish between the different instances of the entity
- Entities are not immutable and are expected to change
- Value objects describe an entity's properties
```
class Person
{
    public readonly PersonId Id;
    public Name Name { get; set; }
    
    public Person(PersonId id, Name name)
    {
        this.Id = id;
        this.Name = name;
    }
}
```

#### Aggregates
- An aggregate is an entity: it requires an explicit identification field and its state is expected to change during an instance's lifecycle
- The goal of the pattern is to protect the consistency of its data
- The aggregate is a consistency enforcement boundary
- Its state can only be mutated by executing corresponding methods of the aggregate's public interface
- An aggregate's public interface is responsible for validating the input and enforcing all of the relevant business rules and invariants
```
public class Ticket
{
    private UserId          _customer;
    private List<ProductId> _products;
    private UserId          _assignedAgent;
    private List<Message>   _messages;
}
```

### Event-Sourced Domain Model
