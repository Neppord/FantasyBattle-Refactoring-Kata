#ifndef FANTASYBATTLE_BUFF_H
#define FANTASYBATTLE_BUFF_H


class Buff {
public:
    Buff(float soakModifier, float damageModifier);

    virtual float getSoakModifier();
    virtual float getDamageModifier();

protected:
    float soakModifier;
    float damageModifier;
};


#endif //FANTASYBATTLE_BUFF_H
