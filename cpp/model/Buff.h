#ifndef FANTASYBATTLE_BUFF_H
#define FANTASYBATTLE_BUFF_H


class Buff {
public:
    virtual float getSoakModifier() = 0;
    virtual float getDamageModifier() = 0;
};


#endif //FANTASYBATTLE_BUFF_H
